package com.yash.ppmtoolapp.domain;

public class Developer {
	private int id;
	private int projectTaskId;
	private String developerName;
	
	public String getDeveloperName() {
		return developerName;
	}
	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProjectTaskId() {
		return projectTaskId;
	}
	public void setProjectTaskId(int projectTaskId) {
		this.projectTaskId = projectTaskId;
	}	
}
