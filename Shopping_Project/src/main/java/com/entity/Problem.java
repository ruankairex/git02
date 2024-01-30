package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "problem")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_id")
    private int problemId;

    @Column(name = "problem_name", length = 30)
    private String problemName;

    public Problem() {
    }

	public Problem(int problemId, String problemName) {
		super();
		this.problemId = problemId;
		this.problemName = problemName;
	}

	public int getProblemId() {
		return problemId;
	}

	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}

	public String getProblemName() {
		return problemName;
	}

	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Problem [problemId=");
		builder.append(problemId);
		builder.append(", problemName=");
		builder.append(problemName);
		builder.append("]");
		return builder.toString();
	}

   
}
