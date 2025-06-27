package com.frdAttendance.demo.service;

import com.frdAttendance.demo.model.ApprovalOfficerPatrolLeader;
import com.frdAttendance.demo.model.CompanyUsers;
import com.frdAttendance.demo.repository.ApprovalOfficerPatrolLeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ApprovalOfficerPatrolLeaderService {

    @Autowired
    private ApprovalOfficerPatrolLeaderRepository approvalOfficerPatrolLeaderRepository;

    public ResponseEntity<ApprovalOfficerPatrolLeader> save(ApprovalOfficerPatrolLeader approvalOfficerPatrolLeader) {
        approvalOfficerPatrolLeader = approvalOfficerPatrolLeaderRepository.save(approvalOfficerPatrolLeader);

        if(approvalOfficerPatrolLeader.getId()==0){
            throw new RuntimeException("Company User id is null");
        }else{
            return ResponseEntity.ok(approvalOfficerPatrolLeader);
        }
    }

}
