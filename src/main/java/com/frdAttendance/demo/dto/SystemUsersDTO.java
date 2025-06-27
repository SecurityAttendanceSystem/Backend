package com.frdAttendance.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SystemUsersDTO {
    private int empId;
    private String userRole;

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getEmpId() {
        return empId;
    }

    public String getUserRole() {
        return userRole;
    }
}
