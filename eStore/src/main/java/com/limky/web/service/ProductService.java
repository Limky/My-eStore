package com.limky.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limky.web.dao.ProductDao;
import com.limky.web.model.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public List<Product> getProducts(){
		return productDao.getProducts();
	}

	public boolean addProduct(Product product) {
		return productDao.addProduct(product);	
	}

	public boolean deleteProduct(int id) {
		return productDao.deleteProduct(id);	
		
	}

	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

	public boolean editProduct(Product product) {
		return productDao.editProduct(product);
	}

	
}
