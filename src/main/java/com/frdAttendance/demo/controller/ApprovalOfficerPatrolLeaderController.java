package com.frdAttendance.demo.controller;

import com.frdAttendance.demo.model.ApprovalOfficerPatrolLeader;
import com.frdAttendance.demo.service.ApprovalOfficerPatrolLeaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/assignPatrolOfficer")
@CrossOrigin(origins = "https://sam.slt.lk/")
public class ApprovalOfficerPatrolLeaderController {

    @Autowired
    private ApprovalOfficerPatrolLeaderService approvalOfficerPatrolLeaderService;

    @PostMapping("/save")
    public ResponseEntity<ApprovalOfficerPatrolLeader> save(@RequestBody ApprovalOfficerPatrolLeader approvalOfficerPatrolLeader) {
        return approvalOfficerPatrolLeaderService.save(approvalOfficerPatrolLeader);
    }

}
