package com.yash.ppmtoolapp.dao;

import java.util.List;


import com.yash.ppmtoolapp.domain.Developer;

public interface DeveloperDAO {
	List<Developer> findAllDevelopers();
}
