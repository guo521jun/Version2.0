package com.xupt.gj.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xupt.gj.bean.Products;
import com.xupt.gj.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(Products product) {
		if (product != null) {
			productService.insert(product.getName(), product.getPrice(), 
					product.getStock(), product.getDescs());
			return "product";
		}
		return "error";
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String list(HttpSession session) {
		List<Products> result = productService.list();
		if (result != null) {
			session.setAttribute("result", result);
			return "detail";
		}
		return "error";
	}
	
	@RequestMapping(value="/back", method=RequestMethod.GET)
	public String back() {
		return "product";
	}
	
	@RequestMapping(value="/get", method=RequestMethod.POST)
	public String get(Integer id, HttpSession session) {
		if (id != null) {
			Products product = productService.get(id);
			if (product != null) {
				session.setAttribute("product", product);
				return "finished";
			}
		}
		return "error";
	}
}
