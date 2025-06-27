package com.frdAttendance.demo.controller;

import com.frdAttendance.demo.model.Attendance;
import com.frdAttendance.demo.model.InternalUsers;
import com.frdAttendance.demo.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "http://localhost:5173")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping(value = "/saveAttendance", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Attendance>> saveAttendance(@RequestBody List<Attendance> attendances) {
        List<Attendance> savedAttendances = attendanceService.saveAllAttendances(attendances);
        return ResponseEntity.ok(savedAttendances);
    }

    @GetMapping("/getAll")
    public List<Attendance> getAllAttendances() {
        return attendanceService.getAllAttendances();
    }

    //get attendance by using serviceNumber
    @GetMapping("/getSpecificAttendanceByCompanyId/{specificCompanyId}")
    public ResponseEntity<List<Attendance>> getAttendanceByCompanyId(@PathVariable String specificCompanyId) {
        List<Attendance> attendanceRecords = attendanceService.getAttendanceByCompanyId(specificCompanyId);

        if (attendanceRecords.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(attendanceRecords);
    }

    //get attendance by using serviceNumber
    @GetMapping("/getAttendanceByEmpId/{empId}")
    public ResponseEntity<List<Attendance>> getAttendanceByEmpId(@PathVariable String empId) {
        List<Attendance> attendanceRecords = attendanceService.getAttendanceRecordById(empId);

        if (attendanceRecords.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(attendanceRecords);
    }

    //officer 01
    @PutMapping("/updateApprovalOfficer01/{id}")
    public ResponseEntity<String> updateApprovalStatus(@PathVariable Long id,@RequestBody String status){
        boolean updated = attendanceService.updateApprovalStatus(id, status);

        if(updated){
            return ResponseEntity.ok("Approval status updated successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Attendance record not found");
        }
    }

    //update rejected notice for approvalOfficer
    @PutMapping("/approvalOfficer01Rejected/{id}")
    public ResponseEntity<String> updateApprovalRejectedNotice(@PathVariable Long id,@RequestBody String rejectedNotice){
        boolean updated = attendanceService.updateApprovalRejectedNotice(id, rejectedNotice);

        if(updated){
            return ResponseEntity.ok("Approval officer rejected notice updated successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Attendance record not found");
        }
    }

    //officer 02
    @PutMapping("/updateApprovalOfficer02/{id}")
    public ResponseEntity<String> updateApproval02Status(@PathVariable Long id,@RequestBody String status){
        boolean updated = attendanceService.updateApproval02Status(id, status);

        if(updated){
            return ResponseEntity.ok("Approval status updated successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Attendance record not found");
        }
    }

    //update rejected notice for approvalOfficer
    @PutMapping("/approvalOfficer02Rejected/{id}")
    public ResponseEntity<String> updateApproval02RejectedNotice(@PathVariable Long id,@RequestBody String rejectedNotice){
        boolean updated = attendanceService.updateApproval02RejectedNotice(id, rejectedNotice);

        if(updated){
            return ResponseEntity.ok("Approval officer rejected notice updated successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Attendance record not found");
        }
    }

    //officer 03
    @PutMapping("/updateApprovalOfficer03/{id}")
    public ResponseEntity<String> updateApproval03Status(@PathVariable Long id,@RequestBody String status){
        boolean updated = attendanceService.updateApproval03Status(id, status);

        if(updated){
            return ResponseEntity.ok("Approval status updated successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Attendance record not found");
        }
    }

    //update rejected notice for approvalOfficer
    @PutMapping("/approvalOfficer03Rejected/{id}")
    public ResponseEntity<String> updateApproval03RejectedNotice(@PathVariable Long id,@RequestBody String rejectedNotice){
        boolean updated = attendanceService.updateApproval03RejectedNotice(id, rejectedNotice);

        if(updated){
            return ResponseEntity.ok("Approval officer rejected notice updated successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Attendance record not found");
        }
    }


}
