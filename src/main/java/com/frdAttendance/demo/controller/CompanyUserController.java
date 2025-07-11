package com.frdAttendance.demo.controller;

import com.frdAttendance.demo.dto.CompanyUserDTO;
import com.frdAttendance.demo.dto.LoginRequest;
import com.frdAttendance.demo.model.CompanyUsers;
import com.frdAttendance.demo.model.InternalUsers;
import com.frdAttendance.demo.model.SecurityStaff;
import com.frdAttendance.demo.model.SystemUsers;
import com.frdAttendance.demo.service.CompanyUserService;
import lombok.Getter;
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
@RequestMapping("api/companyUser")
@CrossOrigin(origins = "https://sam.slt.lk/") // Allow frontend requests
public class CompanyUserController {

    @Autowired
    private CompanyUserService companyUserService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyUsers> saveCompanyUser(@RequestBody CompanyUserDTO companyUserDTO) {
        return companyUserService.saveCompanyUser(companyUserDTO);
    }

    @GetMapping("/getAll")
    public List<CompanyUsers> getAllCompanyUsers() {
        return companyUserService.getAllCompanyUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest.getUserId()+loginRequest.getPassword());
        if (companyUserService.login(loginRequest.getUserId(), loginRequest.getPassword())) {
            return ResponseEntity.ok("login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid Credentials");
        }
    }

    @GetMapping("/getCompanyUser/{userId}")
    public ResponseEntity<CompanyUsers> getUserById(@PathVariable String userId) {
        Optional<CompanyUsers> user = companyUserService.getUserByEmail(userId);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

}
