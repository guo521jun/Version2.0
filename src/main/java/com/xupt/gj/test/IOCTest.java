package com.xupt.gj.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xupt.gj.dao.UserDAO;
import com.xupt.gj.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class IOCTest {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserService userService;
	
	@Test
	public void test() {
		System.out.println(userDAO);
		System.out.println(userService);
	}
}
