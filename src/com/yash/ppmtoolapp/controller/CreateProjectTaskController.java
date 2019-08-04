package com.yash.ppmtoolapp.controller;


import java.io.IOException;

import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ppmtoolapp.domain.ProjectTask;
import com.yash.ppmtoolapp.service.DeveloperService;
import com.yash.ppmtoolapp.serviceimpl.ProjectTaskServiceImpl;
import com.yash.ppmtoolapp.serviceimpl.DeveloperServiceImpl;

@WebServlet("/CreateProjectTaskController")
public class CreateProjectTaskController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ProjectTaskServiceImpl projectTaskServiceImpl = null;
	private ProjectTask projectTask = null;
	private DeveloperService developerService = null;
	
	public CreateProjectTaskController() {
		super();
		projectTaskServiceImpl = new ProjectTaskServiceImpl();
		projectTask = new ProjectTask();
		developerService = new DeveloperServiceImpl();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		projectTask.setAcceptanceCriteria(request.getParameter("acceptanceCriteria"));
		projectTask.setDeveloperId(Integer.parseInt(request.getParameter("developerId")));
		projectTask.setProjectId(Integer.parseInt(request.getParameter("projectId")));
		projectTask.setDueDate(Date.valueOf(request.getParameter("dueDate")));
		projectTask.setPriority(request.getParameter("priority"));
		projectTask.setStatus(request.getParameter("status"));
		projectTask.setSummary(request.getParameter("summary"));
		
		projectTaskServiceImpl.createProjectTask(projectTask);
		
		response.sendRedirect("./ListProjectTaskController?id="+projectTask.getProjectId());
		
	}
}

