package com.frdAttendance.demo.service;

import com.frdAttendance.demo.dto.SecurityCompanyDTO;
import com.frdAttendance.demo.model.InternalUsers;
import com.frdAttendance.demo.model.SecurityCompany;
import com.frdAttendance.demo.model.SystemUsers;
import com.frdAttendance.demo.repository.SecurityCompanyRepository;
import com.frdAttendance.demo.repository.SecurityStaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SecurityCompanyService {
    @Autowired
    private SecurityCompanyRepository repository;
    @Autowired
    private SecurityStaffRepository securityStaffRepository;
    @Autowired
    private SecurityCompanyRepository securityCompanyRepository;

    public ResponseEntity<SecurityCompany> onboardCompany(SecurityCompanyDTO securityCompanyDto) {
        SecurityCompany company = new SecurityCompany();
        company.setCompanyName(securityCompanyDto.getCompanyName());
        company.setCompanyAddress(securityCompanyDto.getCompanyAddress());
        company.setContactNumber(securityCompanyDto.getContactNumber());

        // Save and return
        SecurityCompany savedCompany = securityCompanyRepository.save(company);
        return ResponseEntity.ok(savedCompany);
    }

    public List<SecurityCompany> getAllCompanies() {
        return repository.findAll();
    }

    public long getSecurityCompanyCount() {
        return repository.count();
    }

    public Optional<SecurityCompany> getCompanyById(String companyId) {
        return securityCompanyRepository.findById(companyId);
    }
}
