package com.yash.ppmtoolapp.dao;

import java.util.List;

import com.yash.ppmtoolapp.domain.User;



public interface UserDAO {
	public void save(User user);
	public void update(User user);
	public void delete(Long id);
	public void delete(String email);
	public User findByEmail(String email);
	public List<User> findAll();
}
