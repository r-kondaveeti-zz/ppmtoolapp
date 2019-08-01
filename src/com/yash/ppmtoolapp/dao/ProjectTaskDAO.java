package com.yash.ppmtoolapp.dao;

import java.util.List;

import com.yash.ppmtoolapp.domain.ProjectTask;

public interface ProjectTaskDAO {
	
	void saveProjectTask(ProjectTask projectTask);
	
	
	void deleteProjectTask(ProjectTask projectTask);
	
	
	void updateProjectTask(ProjectTask projectTask);
	
	
	void deleteProjectTask(int id);
	
	
	ProjectTask findProjectTaskById(int id);
	
	
	List<ProjectTask> findAllProjectTask(int id, int developerId);
	
}
