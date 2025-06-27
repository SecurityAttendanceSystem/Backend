package com.frdAttendance.demo.repository;

import com.frdAttendance.demo.model.CompanyUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyUserRepository extends JpaRepository<CompanyUsers,Integer> {
    Optional<CompanyUsers> findByEmail(String userId);
}
