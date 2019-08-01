package com.yash.ppmtoolapp.test;

import com.yash.ppmtoolapp.daoimpl.UserDAOImpl;
import com.yash.ppmtoolapp.domain.User;

public class DAOSaveTest {

	public static void main(String[] args) {
		UserDAOImpl dao = new UserDAOImpl();
		User u = new User();
		u.setName("Adam");
		u.setPassword("Adam");
		u.setEmail("adam@adam.com");
		u.setUserType("dummy");
		
		dao.save(u);
	}

}
