package com.yash.ppmtoolapp.controller;

import java.io.IOException;

import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ppmtoolapp.domain.ProjectTask;
import com.yash.ppmtoolapp.service.ProjectTaskService;
import com.yash.ppmtoolapp.serviceimpl.ProjectTaskServiceImpl;

/**
 * This controller updates the altered values
 * @author Radhithya Kondaveeti
 *
 */
@WebServlet("/UpdateProjectTaskController")
public class UpdateProjectTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProjectTaskService projectTaskService = null;
    private ProjectTask projectTask = null;

    public UpdateProjectTaskController() {
        super();
        projectTaskService= new ProjectTaskServiceImpl();
        projectTask = new ProjectTask();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		projectTask.setId(Integer.parseInt(request.getParameter("id")));
		projectTask.setSummary(request.getParameter("summary"));
		projectTask.setAcceptanceCriteria(request.getParameter("acceptanceCriteria"));
		projectTask.setDeveloperId(Integer.parseInt(request.getParameter("developerId")));
		projectTask.setDueDate(Date.valueOf(request.getParameter("dueDate")));
		projectTask.setPriority(request.getParameter("priority"));
		projectTask.setStatus(request.getParameter("status"));
		
		projectTask.setProjectId((int) request.getSession().getAttribute("projectId"));		
		
		projectTaskService.updateProjectTask(projectTask);
		getServletContext().getRequestDispatcher("/ListProjectTaskController?id="+projectTask.getProjectId()).forward(request, response);
	}


}
