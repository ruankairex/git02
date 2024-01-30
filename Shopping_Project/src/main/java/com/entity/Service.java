package com.entity;

import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complaint_id")
    private int complaintId;

    @Column(name = "complainant_id", nullable = false)
    private Integer complainantId;

    @Column(name = "classification", nullable = false)
    private Integer classification;

    @Column(name = "respondent_id", nullable = false)
    private Integer respondentId;

    @Column(name = "problem_id", nullable = false)
    private Integer problemId;

    @Column(name = "problem_detail", nullable = false, length = 100)
    private String problemDetail;

    @Column(name = "complaint_time")
    private Timestamp complaintTime;

    @Column(name = "finish_time")
    private Timestamp finishTime;

    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;

    @Column(name = "problem_status", nullable = false, length = 20)
    private String problemStatus;

    @Column(name = "status_detail", length = 100)
    private String statusDetail;

    public Service() {
    }

	public Service(Integer complainantId, Integer classification, Integer respondentId, Integer problemId,
			String problemDetail, Timestamp complaintTime, Timestamp finishTime, Integer employeeId,
			String problemStatus, String statusDetail) {
		super();
		this.complainantId = complainantId;
		this.classification = classification;
		this.respondentId = respondentId;
		this.problemId = problemId;
		this.problemDetail = problemDetail;
		this.complaintTime = complaintTime;
		this.finishTime = finishTime;
		this.employeeId = employeeId;
		this.problemStatus = problemStatus;
		this.statusDetail = statusDetail;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public Integer getComplainantId() {
		return complainantId;
	}

	public void setComplainantId(Integer complainantId) {
		this.complainantId = complainantId;
	}

	public Integer getClassification() {
		return classification;
	}

	public void setClassification(Integer classification) {
		this.classification = classification;
	}

	public Integer getRespondentId() {
		return respondentId;
	}

	public void setRespondentId(Integer respondentId) {
		this.respondentId = respondentId;
	}

	public Integer getProblemId() {
		return problemId;
	}

	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}

	public String getProblemDetail() {
		return problemDetail;
	}

	public void setProblemDetail(String problemDetail) {
		this.problemDetail = problemDetail;
	}

	public Timestamp getComplaintTime() {
		return complaintTime;
	}

	public void setComplaintTime(Timestamp complaintTime) {
		this.complaintTime = complaintTime;
	}

	public Timestamp getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getProblemStatus() {
		return problemStatus;
	}

	public void setProblemStatus(String problemStatus) {
		this.problemStatus = problemStatus;
	}

	public String getStatusDetail() {
		return statusDetail;
	}

	public void setStatusDetail(String statusDetail) {
		this.statusDetail = statusDetail;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Service [complaintId=");
		builder.append(complaintId);
		builder.append(", complainantId=");
		builder.append(complainantId);
		builder.append(", classification=");
		builder.append(classification);
		builder.append(", respondentId=");
		builder.append(respondentId);
		builder.append(", problemId=");
		builder.append(problemId);
		builder.append(", problemDetail=");
		builder.append(problemDetail);
		builder.append(", complaintTime=");
		builder.append(complaintTime);
		builder.append(", finishTime=");
		builder.append(finishTime);
		builder.append(", employeeId=");
		builder.append(employeeId);
		builder.append(", problemStatus=");
		builder.append(problemStatus);
		builder.append(", statusDetail=");
		builder.append(statusDetail);
		builder.append("]");
		return builder.toString();
	}

}
