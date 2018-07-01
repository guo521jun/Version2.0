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
//		dao.insert(manager, "库里", "666666", 36);
//		dao.update(manager, 1, "654321", 34);
//		dao.delete(manager, 3);
//		System.out.println(dao.get(1));
//		dao.delete(2);
//		dao.update(1, "123456", 35);
//		dao.insert("哈登", "123456", 36);
//		System.out.println(dao.get("哈登"));
		List<Users> list = dao.list();
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	@Test
	public void test2() {
		ProductDAO dao = new ProductDAO();
		dao.insert("华为荣耀", 3668.8, 100, "你值得拥有!");
	}
}
