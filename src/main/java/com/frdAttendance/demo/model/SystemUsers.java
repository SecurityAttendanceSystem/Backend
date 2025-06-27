package com.frdAttendance.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "system_user")
public class SystemUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int empId; // Unique identifier for the user

    @Column(name = "user_role")
    private String userRole; // The role of the user

    @OneToMany(mappedBy = "systemUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<InternalUsers> internalUsers;

    public int getEmpId() {
        return empId;
    }

    public String getUserRole() {
        return userRole;
    }


    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public void setInternalUsers(List<InternalUsers> internalUsers) {
        this.internalUsers = internalUsers;
    }
}