package com.yash.ppmtoolapp.service;

import java.util.List;

import com.yash.ppmtoolapp.domain.Project;

/**
 * This ProjectService will perform business logic on Project
 * @author nolanschoenle
 *
 */
public interface ProjectService {

	/**
	 * createProject will create the provided project
	 * @param project
	 */
	void createProject(Project project);
	/**
	 * This updateProject will update the provided project
	 */
	void updateProject(Project project);
	/**
	 * This remove project will remove the project with the given id
	 * @param id
	 */
	void removeProject(int id);

	/**
	 * This getProject will return the project with the given id
	 * @param id
	 * @return
	 */
	Project getProject(int id);
	/**
	 * This findAll will gather all of the projects in the db and return them as a list
	 * @return
	 */
	List<Project> getAllProjects();
}
