package com.yash.ppmtoolapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.ppmtoolapp.domain.User;
import com.yash.ppmtoolapp.exception.IncorrectEmailException;
import com.yash.ppmtoolapp.exception.IncorrectPasswordException;
import com.yash.ppmtoolapp.service.UserService;
import com.yash.ppmtoolapp.serviceimpl.UserServiceImpl;



@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {
	
	UserService service = null;
	private static final long serialVersionUID = 1L;
     
    public UserLoginController() {
        this.service = new UserServiceImpl();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside the login controller");
		try {
			if(service.checkEmail(request.getParameter("email"))) {
				if(service.authenticate(request.getParameter("email"), request.getParameter("password"))){
					System.out.println("Inside the try block of doPost" + request.getParameter("email") + " " + request.getParameter("password"));
					User loggedInUser = new User();
					loggedInUser = service.getUser(request.getParameter("email"));
					System.out.println("The email of logged in user is : "+service.getUser(request.getParameter("email")));
					boolean create = true;
					HttpSession session = request.getSession(create);
					session.setAttribute("userEmail", loggedInUser.getEmail());
					session.setAttribute("userName", loggedInUser.getName());
					session.setAttribute("user", loggedInUser);
					response.sendRedirect("dashboard.jsp?msg=success");
				}else{
					System.out.println("Inside the else block of login controller");
					throw new IncorrectPasswordException("Please check your password");
				}
			}else {
				throw new IncorrectEmailException("This email is not in our database");
			}
		}catch(Exception e) {
			response.sendRedirect("login.jsp?msg="+e.getMessage());
		}
	}
}
