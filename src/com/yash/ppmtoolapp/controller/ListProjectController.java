package com.yash.ppmtoolapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ppmtoolapp.domain.Project;
import com.yash.ppmtoolapp.service.ProjectService;
import com.yash.ppmtoolapp.serviceimpl.ProjectServiceImpl;

/**
 * This controller populates the values in the dashboard.jsp page
 * @author Radhithya Kondaveeti
 */
@WebServlet("/ListProjectController")
public class ListProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProjectService projectService = null;

    public ListProjectController() {
        super();
     	projectService = new ProjectServiceImpl();
     	}
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Project> projects = projectService.getAllProjects();
		request.setAttribute("projects", projects);
		getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);		
	}

}
