package com.limky.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.limky.web.model.Product;
import com.limky.web.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public String getProducts(Model model){
		
		List<Product> products = productService.getProducts();
		model.addAttribute("products",products);

		return "products";
	}
	
}
