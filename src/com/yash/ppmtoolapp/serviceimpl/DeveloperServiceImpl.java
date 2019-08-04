package com.yash.ppmtoolapp.serviceimpl;

import java.util.List;

import com.yash.ppmtoolapp.dao.DeveloperDAO;
import com.yash.ppmtoolapp.daoimpl.DeveloperDAOImpl;
import com.yash.ppmtoolapp.domain.Developer;
import com.yash.ppmtoolapp.service.DeveloperService;

public class DeveloperServiceImpl implements DeveloperService {
	private DeveloperDAO developerDAO = null;
	
	public DeveloperServiceImpl() {
		developerDAO = new DeveloperDAOImpl();
	}
	
	
	@Override
	public List<Developer> getAllDevelopers() {
		return developerDAO.findAllDevelopers();
	}
}
