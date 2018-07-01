package com.xupt.gj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xupt.gj.bean.Users;
import com.xupt.gj.dao.UserDAO;
import com.xupt.gj.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void insert(String name, String password, Integer age) {
		userDAO.insert(name, password, age);
	}

	@Override
	public void update(Integer id, String password, Integer age) {
		userDAO.update(id, password, age);
	}

	@Override
	public void delete(Integer id) {
		userDAO.delete(id);
	}

	@Override
	public Users get(Integer id) {
		return userDAO.get(id);
	}

	@Override
	public Users get(String name) {
		if(name != null) {
			return userDAO.get(name);
		}
		return null;
	}

	@Override
	public List<Users> list() {
		return userDAO.list();
	}

}
