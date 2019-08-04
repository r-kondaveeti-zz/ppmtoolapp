package com.yash.ppmtoolapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ppmtoolapp.domain.Developer;
import com.yash.ppmtoolapp.service.DeveloperService;
import com.yash.ppmtoolapp.serviceimpl.DeveloperServiceImpl;

@WebServlet("/RedirectController")
public class RedirectController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("projectId"));
		DeveloperService developer = new DeveloperServiceImpl();
		List<Developer> developers = developer.getAllDevelopers();
		req.getSession().setAttribute("developers", developers);
		
		getServletContext().getRequestDispatcher("/createProjectTask.jsp?projectId="+id).forward(req, resp);
	}

}
