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
 * This Servlet is called when new project information is provided
 * @author Radhithya Kondaveeti
 */

@WebServlet("/CreateProjectController")
public class CreateProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Project project = null;
	ProjectService projectservice = null;


	public CreateProjectController() {
		super();
		project = new Project();
		projectservice = new ProjectServiceImpl();
	}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			project.setName(req.getParameter("name"));
			project.setUniqueProjectId(req.getParameter("uniqueProjectId"));
			project.setManagerId(Integer.parseInt(req.getParameter("managerId")));
			project.setDescription(req.getParameter("description"));
			project.setStartDate(Date.valueOf(req.getParameter("startDate")));
			project.setEndDate(Date.valueOf(req.getParameter("endDate")));
			
			projectservice.createProject(project);
			getServletContext().getRequestDispatcher("/ListProjectController").forward(req, resp);
						
		}

	
}
