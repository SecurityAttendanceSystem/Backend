package com.frdAttendance.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "attendance_records")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "emp_id", nullable = false)
    private String empId;

    @Column(name = "company_id", nullable = false)
    private String companyId;

    @Column(name = "supervisor_no")
    private String supervisorNo;

    @Column(name = "arrival_date", nullable = false)
    private LocalDate arrivalDate;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    @Column(name = "departure_date", nullable = false)
    private LocalDate departureDate;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @Column(name = "shift_type")
    private String shiftType;

    private String duration;

    private String penalty;

    private String remarks;

    @Column(name = "approval_officer01_approval")
    private String approvalOfficer01Approval = "Pending";

    @Column(name = "approval_officer01_rejected Notice")
    private String approvalOfficer01RejectedNotice = "";

    @Column(name = "approval_officer02_approval")
    private String approvalOfficer02Approval = "Pending";

    @Column(name = "approval_officer02_rejected Notice")
    private String approvalOfficer02RejectedNotice = "";

    @Column(name = "approval_officer03_approval")
    private String approvalOfficer03Approval = "Pending";

    @Column(name = "approval_officer03_rejected Notice")
    private String approvalOfficer03RejectedNotice = "";

    @PrePersist
    @PreUpdate
    private void validateDates() {
        if (date == null) {
            date = arrivalDate;
        }

        if (arrivalDate == null || departureDate == null) {
            throw new IllegalStateException("Arrival and departure dates cannot be null");
        }

        if (departureDate.isBefore(arrivalDate)) {
            throw new IllegalStateException("Departure date cannot be before arrival date");
        }
    }

    public Long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate date() {
        return date;
    }

    public String getEmpId() {
        return empId;
    }

    public String getSupervisorNo() {
        return supervisorNo;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public String getShiftType() {
        return shiftType;
    }

    public String getDuration() {
        return duration;
    }

    public String getPenalty() {
        return penalty;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getApprovalOfficer01Approval(String approvalStatus) {
        return approvalOfficer01Approval;
    }

    public void setApprovalOfficer01Approval(String approvalOfficer01Approval) {
        this.approvalOfficer01Approval = approvalOfficer01Approval;
    }

    public String getApprovalOfficer01Approval() {
        return approvalOfficer01Approval;
    }

    public String getApprovalOfficer01RejectedNotice() {
        return approvalOfficer01RejectedNotice;
    }

    public void setApprovalOfficer01RejectedNotice(String approvalOfficer01RejectedNotice) {
        this.approvalOfficer01RejectedNotice = approvalOfficer01RejectedNotice;
    }

    public String getApprovalOfficer02Approval() {
        return approvalOfficer02Approval;
    }

    public void setApprovalOfficer02Approval(String approvalOfficer02Approval) {
        this.approvalOfficer02Approval = approvalOfficer02Approval;
    }

    public String getApprovalOfficer02RejectedNotice() {
        return approvalOfficer02RejectedNotice;
    }

    public void setApprovalOfficer02RejectedNotice(String approvalOfficer02RejectedNotice) {
        this.approvalOfficer02RejectedNotice = approvalOfficer02RejectedNotice;
    }

    public String getApprovalOfficer03Approval() {
        return approvalOfficer03Approval;
    }

    public void setApprovalOfficer03Approval(String approvalOfficer03Approval) {
        this.approvalOfficer03Approval = approvalOfficer03Approval;
    }

    public String getApprovalOfficer03RejectedNotice() {
        return approvalOfficer03RejectedNotice;
    }

    public void setApprovalOfficer03RejectedNotice(String approvalOfficer03RejectedNotice) {
        this.approvalOfficer03RejectedNotice = approvalOfficer03RejectedNotice;
    }
}
