package com.yash.ppmtoolapp.dao;

import java.util.List;

import com.yash.ppmtoolapp.domain.Manager;

public interface ManagerDAO {
	List<Manager> findAllManagers();
}
