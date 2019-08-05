package com.yash.ppmtoolapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ppmtoolapp.domain.User;
import com.yash.ppmtoolapp.exception.IncorrectEmailException;
import com.yash.ppmtoolapp.exception.PasswordMismatchException;
import com.yash.ppmtoolapp.service.UserService;
import com.yash.ppmtoolapp.serviceimpl.UserServiceImpl;



@WebServlet("/UserRegistrationController")
public class UserRegistrationController extends HttpServlet {

	UserService service = null;
	
	private static final long serialVersionUID = 1L;
       
    public UserRegistrationController() {
        this.service = new UserServiceImpl();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Test.");
		
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		request.setAttribute("user", user);
		
		try {
			if(service.validatePassword(request.getParameter("password"), request.getParameter("password2"))){
				
				System.out.println("The user email is in doPost and the value is "+user.getEmail());
				
				if(!service.checkEmail(request.getParameter("email"))) {
					service.createUser(user);
					response.sendRedirect("./login.jsp?msg=User created successfully");
				}
				else {
					throw new IncorrectEmailException("Email already exists");
				}
			}else {
				throw new PasswordMismatchException("Password do not match");
			}
		}catch(Exception e) {
			getServletContext().getRequestDispatcher("/register.jsp?msg="+e.getMessage()).forward(request, response);
		}
		
	}

}
