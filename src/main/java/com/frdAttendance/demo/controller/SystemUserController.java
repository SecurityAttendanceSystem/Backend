package com.frdAttendance.demo.controller;

import com.frdAttendance.demo.dto.SystemUsersDTO;
import com.frdAttendance.demo.model.InternalUsers;
import com.frdAttendance.demo.model.SystemUsers;
import com.frdAttendance.demo.service.SystemUserService;
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
@RequestMapping("/api/systemUser")
//@CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin(origins = "https://sam.slt.lk/") // Allow frontend requests
public class SystemUserController {

    @Autowired
    private SystemUserService systemUserService;

    // Get all users
    @GetMapping("/getAll")
    public List<SystemUsers> getAllUsers() {
        return systemUserService.getAllUsers();
    }

    // Save a new system user
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SystemUsers> saveSystemUser(@RequestBody SystemUsersDTO dto) {
        SystemUsers user = new SystemUsers();
        user.setEmpId(dto.getEmpId());
        user.setUserRole(dto.getUserRole());

        return systemUserService.saveSystemUser(user);
    }


    @GetMapping("/getSystemUser/{empId}")
    public ResponseEntity<SystemUsers> getUserById(@PathVariable int empId) {
        Optional<SystemUsers> user = systemUserService.getUserById(empId);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

}
