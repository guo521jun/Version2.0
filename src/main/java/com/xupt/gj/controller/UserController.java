package com.xupt.gj.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xupt.gj.bean.Users;
import com.xupt.gj.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(Users user, HttpSession session) {
		userService.insert(user.getName(), user.getPassword(), user.getAge());
		session.setAttribute("user", user.getName());
		return "success";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Users user, HttpSession session) {
		if (user != null) {
			Users users = userService.get(user.getName());
			if (users != null) {
				if (users.getName().equals(user.getName()) && users.getPassword().equals(user.getPassword())) {
					session.setAttribute("user", users.getName());
					return "product";
				}
			}
		}
		return "error";
	}
}
