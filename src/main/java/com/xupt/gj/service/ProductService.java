package com.xupt.gj.service;

import java.util.List;

import com.xupt.gj.bean.Products;

public interface ProductService {

	void insert(String name, Double price, Integer stock, String desc);
	
	List<Products> list();
	
	Products get(Integer id);
}
