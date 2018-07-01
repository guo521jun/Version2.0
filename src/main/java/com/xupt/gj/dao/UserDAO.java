package com.xupt.gj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.xupt.gj.bean.Users;

@Repository
public class UserDAO {
	
	private static EntityManager em;
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("user");
		em = emf.createEntityManager();
	}

	/**
	 * 添加用户
	 * @param em
	 * @param name
	 * @param password
	 * @param age
	 */
	public void insert(String name, String password, Integer age) {
		Users user = new Users();
		user.setName(name);
		user.setPassword(password);
		user.setAge(age);
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
//		em.close();
//		emf.close();
	}
	
	/**
	 * 修改用户的密码和年龄
	 * @param em
	 * @param id
	 * @param password
	 * @param age
	 */
	public void update(Integer id, String password, Integer age) {
		em.getTransaction().begin();
		Users user = em.find(Users.class, id);
		user.setPassword(password);
		user.setAge(age);
		em.persist(user);
		em.getTransaction().commit();
//		em.close();
//		emf.close();
	}
	
	/**
	 * 根据id删除用户
	 * @param em
	 * @param id
	 */
	public void delete(Integer id) {
		em.getTransaction().begin();
		Users user = em.find(Users.class, id);
		em.remove(user);
		em.getTransaction().commit();
//		em.close();
//		emf.close();
	}
	
	/**
	 * 根据id查询用户
	 * @param em
	 * @param id
	 * @return
	 */
	public Users get(Integer id) {
		Users user = em.find(Users.class, id);
//		em.close();
//		emf.close();
		return user;
	}
	
	/**
	 * 查找所有用户
	 * @return
	 */
	public List<Users> list() {
		String sql = "SELECT id, name, password, age FROM user_ec";
		Query query = em.createNativeQuery(sql, Users.class);
		List<Users> result = query.getResultList();
//		em.close();
//		emf.close();
		return result;
	}
	
	/**
	 * 根据用户名查询
	 * @param name
	 * @return
	 */
	public Users get(String name) {
		String sql = "SELECT id, name, password, age FROM user_ec WHERE name = ?";
		Users user = (Users) em.createNativeQuery(sql, Users.class)
				.setParameter(1, name).getSingleResult();
//		em.close();
//		emf.close();
		return user;
	}
	
}
