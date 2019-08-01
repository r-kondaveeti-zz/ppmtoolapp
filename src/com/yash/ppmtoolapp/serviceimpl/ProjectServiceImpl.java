package com.yash.ppmtoolapp.serviceimpl;

import java.util.List;

import com.yash.ppmtoolapp.dao.ProjectDAO;
import com.yash.ppmtoolapp.daoimpl.ProjectDAOImpl;
import com.yash.ppmtoolapp.domain.Project;
import com.yash.ppmtoolapp.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {

	private ProjectDAO projectDAO = null;

	public ProjectServiceImpl() {
		this.projectDAO = new ProjectDAOImpl();
	}

	@Override
	public void createProject(Project project) {
		projectDAO.save(project);
	}

	//class
	@Override
	public void updateProject(Project project) {
		projectDAO.update(project);
		
	}

	@Override
	public void removeProject(int id) {
		projectDAO.delete(id);
		
	}

	@Override
	public Project getProject(int id) {
		return projectDAO.findById(id);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectDAO.findAll();
	}

}