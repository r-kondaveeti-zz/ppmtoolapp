package com.yash.ppmtoolapp.serviceimpl;

import java.util.List;

import com.yash.ppmtoolapp.dao.ManagerDAO;
import com.yash.ppmtoolapp.daoimpl.ManagerDAOImpl;
import com.yash.ppmtoolapp.domain.Manager;
import com.yash.ppmtoolapp.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDAO managerDAO = null;
	
	public ManagerServiceImpl() {
		managerDAO = new ManagerDAOImpl();
	}
	
	
	@Override
	public List<Manager> getAllManagers() {
		return managerDAO.findAllManagers();
	}
}
