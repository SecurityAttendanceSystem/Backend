package com.frdAttendance.demo.dto;

import com.frdAttendance.demo.model.CompanyUsers;

import java.util.List;

public class SecurityCompanyDTO {
    private String companyName;
    private String companyAddress;
    private String contactNumber;

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}

