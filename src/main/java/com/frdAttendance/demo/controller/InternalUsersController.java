package com.frdAttendance.demo.controller;

import com.frdAttendance.demo.dto.InternalUsersDTO;
import com.frdAttendance.demo.dto.LoginRequest;
import com.frdAttendance.demo.model.CompanyUsers;
import com.frdAttendance.demo.model.InternalUsers;
import com.frdAttendance.demo.service.InternalUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/internalUser")
@CrossOrigin(origins = "https://sam.slt.lk/")
public class InternalUsersController {

    @Autowired
    private InternalUsersService internalUsersService;

    // Save a new system user
    @PostMapping(value="/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InternalUsers> saveInternalUser(@RequestBody InternalUsersDTO internalUserDTO) {
        return internalUsersService.saveInternalUser(internalUserDTO);
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
//        if (internalUsersService.login(
//                loginRequest.getUserId(),
//                loginRequest.getPassword())) {
//            return ResponseEntity.ok("login successful");
//        } else {
//            return ResponseEntity.status(401).body("Invalid Credentials");
//        }
//    }


    @GetMapping("/getAll")
    public List<InternalUsers> getAllInternalUsers() {
        return internalUsersService.getAllInternalUsers();
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<InternalUsers> getUserById(@PathVariable String userId) {
        Optional<InternalUsers> user = internalUsersService.getUserById(userId);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @GetMapping("/getInternalUsersCount")
    public long getInternalUsersCount() {
        return internalUsersService.getInternalUsersCount();
    }

    @PostMapping("/request-reset")
    public ResponseEntity<String> requestPasswordReset(@RequestParam String email) {
        return internalUsersService.requestPasswordReset(email);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(
            @RequestParam String token,
            @RequestParam String newPassword) {
        return internalUsersService.resetPassword(token, newPassword);
    }

}
