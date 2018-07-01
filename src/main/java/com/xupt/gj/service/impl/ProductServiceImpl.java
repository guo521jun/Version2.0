package com.xupt.gj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xupt.gj.bean.Products;
import com.xupt.gj.dao.ProductDAO;
import com.xupt.gj.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public void insert(String name, Double price, Integer stock, String desc) {
		if (name != null || price != null || stock != null || desc != null)
			productDAO.insert(name, price, stock, desc);
		return;
	}

	@Override
	public List<Products> list() {
		return productDAO.list();
	}

	@Override
	public Products get(Integer id) {
		return productDAO.get(id);
	}

}
