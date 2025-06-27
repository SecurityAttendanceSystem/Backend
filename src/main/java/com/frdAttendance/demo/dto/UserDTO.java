package com.frdAttendance.demo.dto;

public class UserDTO {
    private String userId;
    private String name;
    private String email;
    private String userRole;

    public UserDTO(String userId, String name, String email, String userRole) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.userRole = userRole;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    // Getters and setters (or use Lombok @Data)
}
