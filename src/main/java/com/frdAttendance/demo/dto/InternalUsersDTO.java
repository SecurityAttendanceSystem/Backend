package com.frdAttendance.demo.dto;

// Create this new class
public class InternalUsersDTO {
    private String userId;
    private String name;
    private String contact;
    private String email;
    private String password;
    private SystemUsersDTO systemUser; // Changed to match frontend structure

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public SystemUsersDTO getSystemUser() {
        return systemUser;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSystemUser(SystemUsersDTO systemUser) {
        this.systemUser = systemUser;
    }
}

