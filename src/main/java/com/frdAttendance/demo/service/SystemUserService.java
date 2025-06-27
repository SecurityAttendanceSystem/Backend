package com.frdAttendance.demo.service;

import com.frdAttendance.demo.model.InternalUsers;
import com.frdAttendance.demo.model.SystemUsers;
import com.frdAttendance.demo.repository.SystemUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SystemUserService {


    @Autowired
    private SystemUserRepository systemUserRepository;

    // Get all users
    public List<SystemUsers> getAllUsers() {
        return systemUserRepository.findAll();
    }

    // Save a new system user
    public ResponseEntity<SystemUsers> saveSystemUser(SystemUsers systemUser) {
        systemUser = systemUserRepository.save(systemUser);

        if (systemUser.getEmpId()==0){
            throw new RuntimeException("System User id is null");
        }else{
            return ResponseEntity.ok(systemUser);
        }
    }

    public Optional<SystemUsers> getUserById(int empId) {
        return systemUserRepository.findById(empId);
    }
}
