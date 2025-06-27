package com.frdAttendance.demo.service;

import com.frdAttendance.demo.model.InternalUsers;
import com.frdAttendance.demo.model.SecurityStaff;
import com.frdAttendance.demo.repository.SecurityStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SecurityStaffService {

    @Autowired
    private SecurityStaffRepository securityStaffRepository;

    public ResponseEntity<?> addSecurityStaff(SecurityStaff securityStaff) {
        Map<String, String> errors = validateSecurityStaff(securityStaff);

        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors);
        }

        if (securityStaffRepository.existsByEmpId(securityStaff.getEmpId())) {
            errors.put("empId", "Employee ID already exists");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
        }

        try {
            SecurityStaff savedStaff = securityStaffRepository.save(securityStaff);
            return ResponseEntity.ok(savedStaff);
        } catch (Exception e) {
            errors.put("server", "Error saving security staff: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errors);
        }
    }

    private Map<String, String> validateSecurityStaff(SecurityStaff securityStaff) {
        Map<String, String> errors = new HashMap<>();

        if (!StringUtils.hasText(securityStaff.getName())) {
            errors.put("name", "Name is required");
        }
        if (!StringUtils.hasText(securityStaff.getEmpId())) {
            errors.put("empId", "Employee ID is required");
        }
        if (!StringUtils.hasText(securityStaff.getContact())) {
            errors.put("contact", "Contact number is required");
        }
        if (!StringUtils.hasText(securityStaff.getAddress())) {
            errors.put("address", "Address is required");
        }
        if (!StringUtils.hasText(securityStaff.getSupervisor())) {
            errors.put("supervisor", "Supervisor is required");
        }
        if (!StringUtils.hasText(securityStaff.getCompanyName())) {
            errors.put("companyName", "Company name is required");
        }

        return errors;
    }

    public List<SecurityStaff> getAllSecurityStaff() {
        return securityStaffRepository.findAll();
    }

    public List<SecurityStaff> getSecStaffBySupId(String supervisorId) {
        return securityStaffRepository.findSecurityStaffBySupervisor(supervisorId);
    }

    public long getSecurityOfficersCount(){
        return securityStaffRepository.count();
    }

    public void deleteUserById(String id) {
        if(!securityStaffRepository.existsByEmpId(id)){
            throw new RuntimeException("User Id"+id+"not found");
        }
        securityStaffRepository.deleteById(Integer.valueOf(id));
    }
}