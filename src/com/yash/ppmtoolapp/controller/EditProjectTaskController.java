package com.yash.ppmtoolapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ppmtoolapp.domain.ProjectTask;
import com.yash.ppmtoolapp.service.ProjectTaskService;
import com.yash.ppmtoolapp.serviceimpl.ProjectTaskServiceImpl;

/**
 * When the "Manger" clicks update project info on the project board the control gets redirected to this controller when retrieves the data and redirects to a JSP page
 * @author Radhithya Kondaveeti
 */
@WebServlet("/EditProjectTaskController")
public class EditProjectTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectTaskService projectTaskService = null;
       
 
    public EditProjectTaskController() {
        projectTaskService = new ProjectTaskServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ProjectTask projectTask = projectTaskService.getProjectTask(id);
		projectTask.setId(id);
		request.setAttribute("projectTask", projectTask);
		getServletContext().getRequestDispatcher("/editProjectTask.jsp").forward(request, response);
	}

}
