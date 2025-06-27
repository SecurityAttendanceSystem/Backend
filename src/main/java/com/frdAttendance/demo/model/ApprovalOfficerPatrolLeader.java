package com.frdAttendance.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="approvalOfficer_patrolLeader")
public class ApprovalOfficerPatrolLeader {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="approvalOfficerId", nullable = false)
    private String approvalOfficerId;

    @Column(name="patrolLeaderId", nullable = false)
    private String patrolLeaderId;

    public long getId() {
        return id;
    }

    public String getApprovalOfficerId() {
        return approvalOfficerId;
    }

    public String getPatrolLeaderId() {
        return patrolLeaderId;
    }
}
