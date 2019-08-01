package com.yash.ppmtoolapp.service;

import java.util.List;

import com.yash.ppmtoolapp.domain.ProjectTask;

public interface ProjectTaskService {
	void createProjectTask(ProjectTask projectTask);
	void removeProjectTask(ProjectTask projectTask);
	void removeProjectTask(int id );
	void updateProjectTask(ProjectTask projectTask);
	ProjectTask getProjectTask(int id);
	List <ProjectTask> getAllProjectTasks(int id, int developerId);
}