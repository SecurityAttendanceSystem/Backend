package com.frdAttendance.demo.controller;


import com.frdAttendance.demo.dto.SecurityCompanyDTO;
import com.frdAttendance.demo.model.CompanyUsers;
import com.frdAttendance.demo.model.InternalUsers;
import com.frdAttendance.demo.model.SecurityCompany;
import com.frdAttendance.demo.service.SecurityCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/securityCompany")
@CrossOrigin(origins = "http://localhost:5173")// Allow frontend origin
@RequiredArgsConstructor
public class SecurityCompanyController {
    @Autowired
    private SecurityCompanyService companyService;
    @Autowired
    private SecurityCompanyService securityCompanyService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SecurityCompany> onboardCompany(@RequestBody SecurityCompanyDTO company) {
        return companyService.onboardCompany(company);
    }

    @GetMapping("/all")
    public List<SecurityCompany> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/getSecurityCompanyCount")
    public long getSecurityCompanyCount() {
        return companyService.getSecurityCompanyCount();
    }

    @GetMapping("/getCompany/{companyId}")
    public ResponseEntity<SecurityCompany> getCompanyById(@PathVariable String companyId) {
        Optional<SecurityCompany> company = securityCompanyService.getCompanyById(companyId);
        return company.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

}