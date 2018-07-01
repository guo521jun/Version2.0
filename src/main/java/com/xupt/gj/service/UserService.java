package com.xupt.gj.service;

import java.util.List;

import com.xupt.gj.bean.Users;

public interface UserService {

	void insert(String name, String password, Integer age);
	
	void update(Integer id, String password, Integer age);
	
	void delete(Integer id);
	
	Users get(Integer id);
	
	Users get(String name);
	
	List<Users> list();
}
