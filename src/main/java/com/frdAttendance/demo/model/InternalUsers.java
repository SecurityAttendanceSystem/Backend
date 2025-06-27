package com.frdAttendance.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="internal_users")
public class InternalUsers {

    @Id
    @Column(name="user_id", nullable = false)
    private String userId;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="contact", nullable = false)
    private String contact;

    @Column(name="email", nullable = false,unique = true)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name="emp_id", nullable = false)
    @JsonManagedReference
    private SystemUsers systemUser; // Reference to a single SystemUser

    public String getUserId() {
        return userId;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public SystemUsers getSystemUser() {
        return systemUser;
    }

    public int getEmpId() {
        if (systemUser != null) {
            System.out.println("Emp ID: " + systemUser.getEmpId());
            return systemUser.getEmpId();
        }
        return -99;
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

    public void setSystemUser(SystemUsers systemUser) {
        this.systemUser = systemUser;
    }
}