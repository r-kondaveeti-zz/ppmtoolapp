package com.yash.ppmtoolapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.ppmtoolapp.dao.ProjectDAO;
import com.yash.ppmtoolapp.dao.ProjectTaskDAO;
import com.yash.ppmtoolapp.daoimpl.ProjectDAOImpl;
import com.yash.ppmtoolapp.daoimpl.ProjectTaskDAOImpl;
import com.yash.ppmtoolapp.domain.Developer;
import com.yash.ppmtoolapp.domain.Manager;
import com.yash.ppmtoolapp.domain.ProjectTask;
import com.yash.ppmtoolapp.domain.Project;
import com.yash.ppmtoolapp.domain.User;
import com.yash.ppmtoolapp.exception.IncorrectEmailException;
import com.yash.ppmtoolapp.exception.IncorrectPasswordException;
import com.yash.ppmtoolapp.service.ManagerService;
import com.yash.ppmtoolapp.service.UserService;
import com.yash.ppmtoolapp.serviceimpl.DeveloperServiceImpl;
import com.yash.ppmtoolapp.serviceimpl.ManagerServiceImpl;
import com.yash.ppmtoolapp.serviceimpl.ProjectTaskServiceImpl;
import com.yash.ppmtoolapp.serviceimpl.UserServiceImpl;



@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {
	
	UserService service = null;
	ManagerService managerService = null;
	ProjectDAO projectDAO = null;
	private static final long serialVersionUID = 1L;
     
    public UserLoginController() {
        this.service = new UserServiceImpl();
        managerService = new ManagerServiceImpl();
		projectDAO = new ProjectDAOImpl();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "You don't have any tasks assigned yet!";
		
		try {
			if(service.checkEmail(request.getParameter("email"))) {
				if(service.authenticate(request.getParameter("email"), request.getParameter("password"))){
					User loggedInUser = new User();
					loggedInUser = service.getUser(request.getParameter("email"));
					boolean create = true;
					HttpSession session = request.getSession(create);
					session.setAttribute("userEmail", loggedInUser.getEmail());
					session.setAttribute("userName", loggedInUser.getName());
					session.setAttribute("user", loggedInUser);
					if(Integer.parseInt(loggedInUser.getUserType())== 1) { 
						List<Manager> managers = managerService.getAllManagers();
						List<Manager> managerList = new ArrayList<>();
						for(Manager manager: managers) {
							List<Project> projects = projectDAO.findAllProjectsByManagerId(manager.getId());
							System.out.println(manager.getManagerName());
							if(projects.isEmpty()) {
								managerList.add(manager);
							}
								else {
								System.out.println("The manager can't be assigned to another task");
							}
						}
						request.getSession().setAttribute("managers", managerList);
						getServletContext().getRequestDispatcher("/ListProjectController").forward(request, response);
					 
					} else if(Integer.parseInt(loggedInUser.getUserType())== 3){
						List<ProjectTask> projectTasks = new ProjectTaskDAOImpl().findAllProjectTask(loggedInUser.getId());						
						if(projectTasks.size() == 0) {
							response.sendRedirect("login.jsp?msg="+message);
						} else {
							int projectId = projectTasks.get(0).getProjectId();
							getServletContext().getRequestDispatcher("/ListProjectTaskController?id="+projectId).forward(request, response);
						}
					} else {
						getServletContext().getRequestDispatcher("/ListProjectController").forward(request, response);
						System.out.println("No Manager");
					}
				} else {
					throw new IncorrectPasswordException("Please check your password");
				}
			} else {
				throw new IncorrectEmailException("This email is not in our database");
			}
		} catch(Exception e) {
			response.sendRedirect("login.jsp?msg="+e.getMessage());
		}
		
		
	}
}
