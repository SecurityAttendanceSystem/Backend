package com.frdAttendance.demo.controller;

import com.frdAttendance.demo.dto.UserDTO;
import com.frdAttendance.demo.model.InternalUsers;
import com.frdAttendance.demo.repository.InternalUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "https://sam.slt.lk/")
public class AuthController {
    @Autowired
    private InternalUsersRepository userRepository;

    @GetMapping("/me")
    public ResponseEntity<?> getUserFromAzureToken(@AuthenticationPrincipal Jwt jwt) {
        String email = jwt.getClaim("preferred_username");
        Optional<InternalUsers> userOpt = userRepository.findByEmail(email);

        if (userOpt.isPresent()) {
            InternalUsers user = userOpt.get();

            UserDTO dto = new UserDTO(
                    user.getUserId(),
                    user.getName(),
                    user.getEmail(),
                    user.getSystemUser().getUserRole()  // safely extract
            );

            return ResponseEntity.ok(dto);  // ✅ only clean fields sent to frontend
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("User not found in local database.");
        }
    }


}
