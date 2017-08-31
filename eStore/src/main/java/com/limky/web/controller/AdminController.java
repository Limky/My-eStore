package com.limky.web.controller;

import java.awt.Dialog.ModalExclusionType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.limky.web.model.Product;
import com.limky.web.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping
	public String adminPage(){
		return "admin";
	}
	
	@RequestMapping("/productInventory")
	public String getProducts(Model model){	
		List<Product> products = productService.getProducts();
		model.addAttribute("products", products);
		
		return "productInventory";
	}

	@RequestMapping("/productInventory/addProduct")
	public String addProduct(Model model){
		Product product = new Product();
		
		product.setName("노트북");
		product.setCategory("컴퓨터");
		model.addAttribute("product",product);
		return "addProduct";
		
	}
	
}
