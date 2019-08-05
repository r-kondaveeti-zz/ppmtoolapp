package com.yash.ppmtoolapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ppmtoolapp.dao.ProjectTaskDAO;
import com.yash.ppmtoolapp.daoimpl.ProjectTaskDAOImpl;
import com.yash.ppmtoolapp.domain.Developer;
import com.yash.ppmtoolapp.domain.ProjectTask;
import com.yash.ppmtoolapp.service.DeveloperService;
import com.yash.ppmtoolapp.serviceimpl.DeveloperServiceImpl;

@WebServlet("/RedirectController")
public class RedirectController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	DeveloperService developerService = null;
	ProjectTaskDAO taskDAO = null;
	
	public RedirectController() {
		developerService = new DeveloperServiceImpl();
		taskDAO = new ProjectTaskDAOImpl();
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("projectId"));
		
		List<Developer> developers = developerService.getAllDevelopers();
		List<Developer> finalList = new ArrayList<>();
		for(Developer developer: developers) {
			List<ProjectTask> projectTasks = taskDAO.findAllProjectTask(developer.getId());
			if(projectTasks.isEmpty()) {
				finalList.add(developer);
			} else if(projectTasks.get(0).getProjectId()==id){
				finalList.add(developer);
			} else {
				System.out.println("The developer can't be assigned to another task");
			}
		}
		req.getSession().setAttribute("developers", finalList);
		
		getServletContext().getRequestDispatcher("/createProjectTask.jsp?projectId="+id).forward(req, resp);
	}

}
