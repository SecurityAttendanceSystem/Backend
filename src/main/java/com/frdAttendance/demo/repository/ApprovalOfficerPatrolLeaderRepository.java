package com.frdAttendance.demo.repository;

import com.frdAttendance.demo.model.ApprovalOfficerPatrolLeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalOfficerPatrolLeaderRepository extends JpaRepository<ApprovalOfficerPatrolLeader, Long> {
}
