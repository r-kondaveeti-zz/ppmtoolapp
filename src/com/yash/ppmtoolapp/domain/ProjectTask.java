package com.yash.ppmtoolapp.domain;

import java.sql.Date;

public class ProjectTask {
	
	private int id;
	private String summary;
	private String acceptanceCriteria;
	private Date dueDate;
	private String priority;
	private String status;
	private int projectId;
	private int developerId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAcceptanceCriteria() {
		return acceptanceCriteria;
	}
	public void setAcceptanceCriteria(String acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}
	
	@Override
	public String toString() {
		return "ProjectTask [id=" + id + ", summary=" + summary + ", acceptanceCriteria=" + acceptanceCriteria
				+ ", dueDate=" + dueDate + ", priority=" + priority + ", status=" + status + ", projectId=" + projectId
				+ ", developerId=" + developerId + "]";
	}
	
}
