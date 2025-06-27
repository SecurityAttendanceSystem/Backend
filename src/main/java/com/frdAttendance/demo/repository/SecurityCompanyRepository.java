package com.frdAttendance.demo.repository;

import com.frdAttendance.demo.model.SecurityCompany;
import com.frdAttendance.demo.model.SystemUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityCompanyRepository extends JpaRepository<SecurityCompany, String> {

}
