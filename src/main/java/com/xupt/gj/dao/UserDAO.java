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
	 * ����û�
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
	 * �޸��û������������
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
	 * ����idɾ���û�
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
	 * ����id��ѯ�û�
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
	 * ���������û�
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
	 * �����û�����ѯ
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
