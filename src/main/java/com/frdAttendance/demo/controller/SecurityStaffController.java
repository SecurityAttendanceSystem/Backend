package com.frdAttendance.demo.controller;

import com.frdAttendance.demo.model.InternalUsers;
import com.frdAttendance.demo.model.SecurityStaff;
import com.frdAttendance.demo.service.SecurityStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/security-staff")
@CrossOrigin(origins = "https://sam.slt.lk/")
public class SecurityStaffController {

    @Autowired
    private SecurityStaffService securityStaffService;

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addSecurityStaff(@RequestBody SecurityStaff securityStaff) {
        return securityStaffService.addSecurityStaff(securityStaff);
    }

    @GetMapping("/all")
    public List<SecurityStaff> getAllSecurityStaff() {
        return securityStaffService.getAllSecurityStaff();
    }

    @GetMapping("/getSecurityStaff/{userId}")
    public ResponseEntity<?> getSecStaffBySupId(@PathVariable String userId) {
        List<SecurityStaff> staffList = securityStaffService.getSecStaffBySupId(userId);

        if (staffList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No security staff found for supervisor: " + userId);
        }

        return ResponseEntity.ok(staffList);
    }

    @GetMapping("/getSecurityOfficersCount")
    public long getSecurityOfficersCount(){
        return securityStaffService.getSecurityOfficersCount();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSecurityStaff(@PathVariable String id) {
        securityStaffService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted security staff: " + id);
    }
}