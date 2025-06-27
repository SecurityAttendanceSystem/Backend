package com.frdAttendance.demo.repository;

import com.frdAttendance.demo.model.InternalUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InternalUsersRepository extends JpaRepository<InternalUsers, String> {
    Optional<InternalUsers> findByUserId(String userId);

    Optional<InternalUsers> findByEmail(String email);
}
