package com.yash.ppmtoolapp.serviceimpl;

import java.util.List;

import com.yash.ppmtoolapp.dao.ProjectTaskDAO;
import com.yash.ppmtoolapp.daoimpl.ProjectTaskDAOImpl;
import com.yash.ppmtoolapp.domain.ProjectTask;
import com.yash.ppmtoolapp.service.ProjectTaskService;

public class ProjectTaskServiceImpl implements ProjectTaskService{
	
	private ProjectTaskDAO projectTaskDAO= null;
	
	public ProjectTaskServiceImpl() {
		this.projectTaskDAO = new ProjectTaskDAOImpl();
	}

	@Override
	public void createProjectTask(ProjectTask projectTask) {
		projectTaskDAO.saveProjectTask(projectTask);;
		
	}

	@Override
	public void removeProjectTask(ProjectTask projectTask) {
		projectTaskDAO.deleteProjectTask(projectTask);
		
	}

	@Override
	public void removeProjectTask(int id) {
		projectTaskDAO.deleteProjectTask(id);
	}

	@Override
	public void updateProjectTask(ProjectTask projectTask) {
		projectTaskDAO.updateProjectTask(projectTask);
		
	}

	@Override
	public ProjectTask getProjectTask(int id) {
		
		return projectTaskDAO.findProjectTaskById(id);
	}

	@Override
	public List<ProjectTask> getAllProjectTasks(int id, int developerId) {
		
		return projectTaskDAO.findAllProjectTask(id, developerId);
	}

}