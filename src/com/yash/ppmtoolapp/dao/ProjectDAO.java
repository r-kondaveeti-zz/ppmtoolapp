package com.yash.ppmtoolapp.dao;

import java.util.List;

import com.yash.ppmtoolapp.domain.Project;
/**
 * This ContactDAO interface will provide the CRUD operations on Contact
 * 
 * @author nolanschoenle
 *
 */
public interface ProjectDAO {
	
	/**
	 * This save operation will save the provided project.
	 * 
	 * @param contact Project to be saved
	 */
	void save(Project project);

	/**
	 * This update operation will update the project detail provided in the project.
	 * 
	 * @param contact a copy of the project with the updated information
	 */
	void update(Project project);

	/**
	 * This delete operation will be deleting the project based on id provided
	 * @param id the project id
	 * @throws UserIDException throws exception if id not found
	 */
	void delete(int id);

	/**
	 * This delete operation will be deleting the project based on Project provided
	 * 
	 * @param project the project to delete
	 */
	void delete(Project project);

	/**
	 * This findbyId operation will be fetching the records from repository based on
	 * the provided id
	 * 
	 * @param id id of project
	 * @return project if found otherwise null
	 */
	Project findById(int id);

	/**
	 * This findAll operation will be fetching all the project records from
	 * repository
	 * 
	 * @return list of contacts if found. Otherwise null.
	 */
	List<Project> findAll();


}
