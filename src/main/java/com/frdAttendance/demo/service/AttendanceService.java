package com.frdAttendance.demo.service;

import com.frdAttendance.demo.model.Attendance;
import com.frdAttendance.demo.model.CompanyUsers;
import com.frdAttendance.demo.model.InternalUsers;
import com.frdAttendance.demo.repository.AttendanceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;


    public List<Attendance> saveAllAttendances(List<Attendance> attendances) {
        return attendanceRepository.saveAll(attendances);
    }

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    public List<Attendance> getAttendanceRecordById(String empId) {
        return attendanceRepository.findByEmpId(empId);
    }

    public List<Attendance> getAttendanceByCompanyId(String specificCompanyId) {
        return attendanceRepository.findByCompanyId(specificCompanyId);
    }

    //approval officer 01
    public boolean updateApprovalStatus(Long id,String approvalStatus){
        Optional<Attendance> optionalAttendance2 = attendanceRepository.findById(id);

        if(optionalAttendance2.isPresent()){
            Attendance attendance = optionalAttendance2.get();
            attendance.setApprovalOfficer01Approval(approvalStatus);
            attendanceRepository.save(attendance);
            return true;
        }

        return false;
    }

    //approval officer rejected notice
    public boolean updateApprovalRejectedNotice(Long id,String rejectedNotice){
        Optional<Attendance> optionalAttendance2 = attendanceRepository.findById(id);

        if(optionalAttendance2.isPresent()){
            Attendance attendance = optionalAttendance2.get();
            attendance.setApprovalOfficer01RejectedNotice(rejectedNotice);
            attendanceRepository.save(attendance);
            return true;
        }

        return false;
    }

    //approval officer 02
    public boolean updateApproval02Status(Long id,String approvalStatus){
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);

        if(optionalAttendance.isPresent()){
            Attendance attendance = optionalAttendance.get();
            attendance.setApprovalOfficer02Approval(approvalStatus);
            attendanceRepository.save(attendance);
            return true;
        }

        return false;
    }

    //approval officer rejected notice
    public boolean updateApproval02RejectedNotice(Long id,String rejectedNotice){
        Optional<Attendance> optionalAttendance2 = attendanceRepository.findById(id);

        if(optionalAttendance2.isPresent()){
            Attendance attendance = optionalAttendance2.get();
            attendance.setApprovalOfficer02RejectedNotice(rejectedNotice);
            attendanceRepository.save(attendance);
            return true;
        }

        return false;
    }

    //approval officer 03
    public boolean updateApproval03Status(Long id,String approvalStatus){
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);

        if(optionalAttendance.isPresent()){
            Attendance attendance = optionalAttendance.get();
            attendance.setApprovalOfficer03Approval(approvalStatus);
            attendanceRepository.save(attendance);
            return true;
        }

        return false;
    }

    //approval officer rejected notice
    public boolean updateApproval03RejectedNotice(Long id,String rejectedNotice){
        Optional<Attendance> optionalAttendance2 = attendanceRepository.findById(id);

        if(optionalAttendance2.isPresent()){
            Attendance attendance = optionalAttendance2.get();
            attendance.setApprovalOfficer03RejectedNotice(rejectedNotice);
            attendanceRepository.save(attendance);
            return true;
        }

        return false;
    }

}
