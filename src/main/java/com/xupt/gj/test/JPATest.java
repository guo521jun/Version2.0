package com.xupt.gj.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.xupt.gj.bean.Users;
import com.xupt.gj.dao.ProductDAO;
import com.xupt.gj.dao.UserDAO;
import com.xupt.gj.service.ProductService;

public class JPATest {

	@Test
	public void test1() {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("user");
//		EntityManager manager = factory.createEntityManager();
		UserDAO dao = new UserDAO();
//		dao.insert(manager, "����", "666666", 36);
//		dao.update(manager, 1, "654321", 34);
//		dao.delete(manager, 3);
//		System.out.println(dao.get(1));
//		dao.delete(2);
//		dao.update(1, "123456", 35);
//		dao.insert("����", "123456", 36);
//		System.out.println(dao.get("����"));
		List<Users> list = dao.list();
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	@Test
	public void test2() {
		ProductDAO dao = new ProductDAO();
		dao.insert("��Ϊ��ҫ", 3668.8, 100, "��ֵ��ӵ��!");
	}
}
