package com.yash.ppmtoolapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ppmtoolapp.domain.Project;
import com.yash.ppmtoolapp.service.ProjectService;
import com.yash.ppmtoolapp.serviceimpl.ProjectServiceImpl;

/**
 * When the "Admin User" clicks update project info on the dashboard the control gets redirected to this controller when retrieves the data and redirects to a JSP page
 * @author Radhithya Kondaveeti
 */
@WebServlet("/EditProjectController")
public class EditProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectService projectService = null;
       
 
    public EditProjectController() {
        projectService = new ProjectServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Project project = projectService.getProject(id);
		project.setId(id);
		request.setAttribute("project", project);
		getServletContext().getRequestDispatcher("/editProject.jsp").forward(request, response);
	}

}
