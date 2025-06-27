package com.frdAttendance.demo.service;

import com.frdAttendance.demo.dto.CompanyUserDTO;
import com.frdAttendance.demo.model.CompanyUsers;
import com.frdAttendance.demo.model.InternalUsers;
import com.frdAttendance.demo.model.SecurityStaff;
import com.frdAttendance.demo.repository.CompanyUserRepository;
import com.frdAttendance.demo.repository.SecurityCompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyUserService {

    @Autowired
    private CompanyUserRepository companyUserRepository;

    @Autowired
    private SecurityCompanyRepository securityCompanyRepository;

    @Autowired
    private EmailService emailService;

    public ResponseEntity<CompanyUsers> saveCompanyUser(CompanyUserDTO companyUserDTO) {
        CompanyUsers companyUser = new CompanyUsers();
        companyUser.setName(companyUserDTO.getName());
        companyUser.setDesignation(companyUserDTO.getDesignation());
        companyUser.setEmail(companyUserDTO.getEmail());
        companyUser.setContactNumber(companyUserDTO.getContactNumber());
        companyUser.setPassword(companyUserDTO.getPassword());
        companyUser.setAddress(companyUserDTO.getAddress());
        
        // Set company
        securityCompanyRepository.findById(companyUserDTO.getCompanyId())
            .ifPresent(companyUser::setCompany);

        companyUser = companyUserRepository.save(companyUser);

        if(companyUser.getId() == 0) {
            throw new RuntimeException("Company User id is null");
        } else {
            emailService.sendUserCreationEmail(
                companyUser.getEmail(),
                companyUser.getEmail(),
                companyUser.getName(),
                companyUser.getPassword()
            );
            return ResponseEntity.ok(companyUser);
        }
    }

    public List<CompanyUsers> getAllCompanyUsers(){
        return companyUserRepository.findAll();
    }

    public boolean login(String userId, String password) {
        System.out.println(userId);
        Optional<CompanyUsers> userOptional = companyUserRepository.findByEmail(userId);
        if (userOptional.isPresent()) {
            CompanyUsers user = userOptional.get();
            return user.getPassword().equals(password);
        }
        return false;
    }

    public Optional<CompanyUsers> getUserByEmail(String userId) {
        return companyUserRepository.findByEmail(userId);
    }

}
