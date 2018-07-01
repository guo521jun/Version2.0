package com.xupt.gj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.xupt.gj.bean.Products;
import com.xupt.gj.bean.Users;

@Repository
public class ProductDAO {

	private static EntityManager em;
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("product");
		em = emf.createEntityManager();
	}

	/**
	 * 添加产品
	 * @param em
	 * @param name
	 * @param password
	 * @param age
	 */
	public void insert(String name, Double price, Integer stock, String desc) {
		Products product = new Products();
		product.setName(name);
		product.setPrice(price);
		product.setStock(stock);
		product.setDescs(desc);
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
//		em.close();
//		emf.close();
	}
	
	/**
	 * 根据id删除商品
	 * @param em
	 * @param id
	 */
	public void delete(Integer id) {
		em.getTransaction().begin();
		Products product = em.find(Products.class, id);
		em.remove(product);
		em.getTransaction().commit();
//		em.close();
//		emf.close();
	}
	
	/**
	 * 根据id查询商品
	 * @param em
	 * @param id
	 * @return
	 */
	public Products get(Integer id) {
		Products product = em.find(Products.class, id);
//		em.close();
//		emf.close();
		return product;
	}
	
	/**
	 * 查找所有产品
	 * @return
	 */
	public List<Products> list() {
		String sql = "SELECT id, name, price, stock, descs FROM product_ec";
		Query query = em.createNativeQuery(sql, Products.class);
		List<Products> result = query.getResultList();
//		em.close();
//		emf.close();
		return result;
	}
	
	/**
	 * 根据商品名查询
	 * @param name
	 * @return
	 */
	public Products get(String name) {
		String sql = "SELECT id, name, price, stock, descs FROM product_ec WHERE name = ?";
		Products product = (Products) em.createNativeQuery(sql, Users.class)
				.setParameter(1, name).getSingleResult();
//		em.close();
//		emf.close();
		return product;
	}
	
}
