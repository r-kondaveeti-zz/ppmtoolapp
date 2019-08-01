package com.yash.ppmtoolapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ppmtoolapp.service.ProjectService;
import com.yash.ppmtoolapp.serviceimpl.ProjectServiceImpl;


@WebServlet("/DeleteProjectController")
public class DeleteProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProjectService projectService = null;

    public DeleteProjectController() {
        super();
        projectService = new ProjectServiceImpl();
			
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		projectService.removeProject(id);
		getServletContext().getRequestDispatcher("/ListProjectController").forward(request, response);
	}

}
