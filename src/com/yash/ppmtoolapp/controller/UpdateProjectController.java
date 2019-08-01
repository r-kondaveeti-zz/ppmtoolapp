package com.yash.ppmtoolapp.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ppmtoolapp.domain.Project;
import com.yash.ppmtoolapp.service.ProjectService;
import com.yash.ppmtoolapp.serviceimpl.ProjectServiceImpl;

/**
 * This controller updates the altered values
 * @author Radhithya Kondaveeti
 *
 */
@WebServlet("/UpdateProjectController")
public class UpdateProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProjectService projectService = null;
    private Project project = null;

    public UpdateProjectController() {
        super();
        projectService= new ProjectServiceImpl();
        project = new Project();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		project.setId(Integer.parseInt(request.getParameter("id")));
		project.setName(request.getParameter("name"));
		project.setUniqueProjectId(request.getParameter("uniqueProjectId"));
		project.setManagerId(Integer.parseInt(request.getParameter("managerId")));
		project.setDescription(request.getParameter("description"));
		project.setStartDate(Date.valueOf(request.getParameter("startDate")));
		project.setEndDate(Date.valueOf(request.getParameter("endDate")));
		
		projectService.updateProject(project);
		getServletContext().getRequestDispatcher("/ListProjectController").forward(request, response);
	}


}
