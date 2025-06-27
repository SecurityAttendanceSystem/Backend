package com.frdAttendance.demo.service;

import com.frdAttendance.demo.dto.InternalUsersDTO;
import com.frdAttendance.demo.model.InternalUsers;
import com.frdAttendance.demo.model.PasswordResetToken;
import com.frdAttendance.demo.model.SystemUsers;
import com.frdAttendance.demo.repository.InternalUsersRepository;
import com.frdAttendance.demo.repository.PasswordResetTokenRepository;
import com.frdAttendance.demo.repository.SystemUserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Getter
@Setter

public class InternalUsersService {

    private static final java.util.UUID UUID = java.util.UUID.randomUUID();

    @Autowired
    private InternalUsersRepository internalUsersRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    private SystemUserRepository systemUsersRepository;


    public ResponseEntity<InternalUsers> saveInternalUser(InternalUsersDTO internalUserDTO) {
        // Convert DTO to entity
        InternalUsers internalUser = new InternalUsers();
        internalUser.setUserId(internalUserDTO.getUserId());
        internalUser.setName(internalUserDTO.getName());
        internalUser.setContact(internalUserDTO.getContact());
        internalUser.setEmail(internalUserDTO.getEmail());
        internalUser.setPassword(internalUserDTO.getPassword());

        // Find and set the SystemUsers entity
        SystemUsers systemUser = systemUsersRepository.findById(internalUserDTO.getSystemUser().getEmpId())
                .orElseThrow(() -> new RuntimeException("System user not found"));
        internalUser.setSystemUser(systemUser);

        // Save and return
        InternalUsers savedUser = internalUsersRepository.save(internalUser);
        return ResponseEntity.ok(savedUser);
    }

    public boolean login(String userId, String password) {
        Optional<InternalUsers> userOptional = internalUsersRepository.findByUserId(userId);
        if (userOptional.isPresent()) {
            InternalUsers user = userOptional.get();
            int userEmpId = user.getEmpId();
            System.out.println(userEmpId);

            // Check for invalid empId (-99 indicates systemUser was null)
            if (userEmpId == -99) {
                return false;
            }

            return user.getPassword().equals(password);
        }
        return false;
    }


    public List<InternalUsers> getAllInternalUsers() {
        return internalUsersRepository.findAll();
    }

    public Optional<InternalUsers> getUserById(String userId) {
        return internalUsersRepository.findByUserId(userId);
    }

    public long getInternalUsersCount() {
        return internalUsersRepository.count();
    }

    public ResponseEntity<String> requestPasswordReset(String email) {
        Optional<InternalUsers> userOptional = internalUsersRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");
        }

        InternalUsers user = userOptional.get();
        String token = UUID.randomUUID().toString();
        PasswordResetToken resetToken = new PasswordResetToken(token, user);
        passwordResetTokenRepository.save(resetToken);

        // Send email with reset link
        emailService.sendPasswordResetEmail(user.getEmail(), token);

        return ResponseEntity.ok("Password reset link sent to your email");
    }

    public ResponseEntity<String> resetPassword(String token, String newPassword) {
        Optional<PasswordResetToken> resetToken = passwordResetTokenRepository.findByToken(token);
        if (resetToken.isEmpty() || resetToken.get().isExpired()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or expired token");
        }

        InternalUsers user = resetToken.get().getUser();
        user.setPassword(newPassword); // In production, hash this password
        internalUsersRepository.save(user);

        // Invalidate the token
        passwordResetTokenRepository.delete(resetToken.get());

        return ResponseEntity.ok("Password updated successfully");
    }
}
