package com.yash.ppmtoolapp.service;

import java.util.List;

import com.yash.ppmtoolapp.domain.User;
import com.yash.ppmtoolapp.exception.PasswordMismatchException;



public interface UserService {
	void createUser(User user);

	void updateUser(User user);

	void removeUser(String email);

	User getUser(String email);

	List<User> getAllUsers();
	
	boolean validatePassword(String originalPassword, String confirmPassword) throws PasswordMismatchException;
	
	boolean authenticate(String email, String password);
	
	boolean checkEmail(String email);
}
