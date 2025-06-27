package com.frdAttendance.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyUserDTO {
    private String name;
    private String designation;
    private String email;
    private String contactNumber;
    private String password;
    private String address;
    private String companyId;

    public String getCompanyId() {
        return companyId;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getDesignation() {
        return designation;
    }

    public String getName() {
        return name;
    }
}
