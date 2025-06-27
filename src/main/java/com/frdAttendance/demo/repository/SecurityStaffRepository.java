package com.frdAttendance.demo.repository;

import com.frdAttendance.demo.model.InternalUsers;
import com.frdAttendance.demo.model.SecurityStaff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SecurityStaffRepository extends JpaRepository<SecurityStaff, Integer> {
    boolean existsByEmpId(String empId);
    List<SecurityStaff> findSecurityStaffBySupervisor(String supervisor);
}