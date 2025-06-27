package com.frdAttendance.demo.repository;

import com.frdAttendance.demo.model.SystemUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUsers, Integer> {

}
