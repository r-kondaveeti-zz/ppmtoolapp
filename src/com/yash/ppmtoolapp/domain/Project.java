package com.yash.ppmtoolapp.domain;

import java.sql.Date;

/**
 * This is Project Object class used to persist project info in the db
 * @author Radhithya Kondaveeti
 *
 */

public class Project {
	private int id;
	private String name;
	private String uniqueProjectId;
	private String Description;
	private Date startDate;
	private Date endDate;
	private int managerId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUniqueProjectId() {
		return uniqueProjectId;
	}
	public void setUniqueProjectId(String uniqueProjectId) {
		this.uniqueProjectId = uniqueProjectId;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", uniqueProjectId=" + uniqueProjectId + ", Description="
				+ Description + ", startDate=" + startDate + ", endDate=" + endDate + ", managerId=" + managerId + "]";
	}
	
	
	
}