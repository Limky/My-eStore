package com.limky.web.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.limky.web.model.Product;
import com.limky.web.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProductService productService;

	@RequestMapping
	public String adminPage() {
		return "admin";
	}

	@RequestMapping("/productInventory")
	public String getProducts(Model model) {
		List<Product> products = productService.getProducts();
		model.addAttribute("products", products);

		return "productInventory";
	}

	@RequestMapping("/productInventory/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();

		product.setName("노트북");
		product.setCategory("컴퓨터");
		model.addAttribute("product", product);
		return "addProduct";

	}

	@RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.POST)
	public String addProductPost(@Valid Product product, BindingResult result, HttpServletRequest request) {

		// Spring에서 product객체에 자동 binding을 시켜줌
		if (result.hasErrors()) {
			System.out.println("===Form data has some errors===");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "addProduct";
		}

		MultipartFile productImage = product.getProductImage();
		/** 루트 디렉토리 가져오는 작업 **/
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path savePath = Paths
				.get(rootDirectory + "\\resources\\images\\uploadfile\\" + productImage.getOriginalFilename());
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(savePath.toString()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		product.setImageFilename(productImage.getOriginalFilename());

		if (!productService.addProduct(product)) {
			System.out.println("Adding Product cannot be done");
		}
		// DB조회를 한 후 페이지에 보여주는 Method에게 위임
		return "redirect:/admin/productInventory";

	}

	@RequestMapping(value = "/productInventory/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id, HttpServletRequest request) {

		Product product = productService.getProductById(id);
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path path = Paths
				.get(rootDirectory + "\\resources\\images\\uploadfile\\" + product.getImageFilename());
		
		/**imagefile delete**/
		if(Files.exists(path)){
				try {
					Files.delete(path);
				} catch (IOException e) {
					e.printStackTrace();
				}

		}
		if (!productService.deleteProduct(id)) {
			System.out.println("Deleting Product cannot be done");
		}
	
		
		// DB조회를 한 후 페이지에 보여주는 Method에게 위임
		return "redirect:/admin/productInventory";
	}

	@RequestMapping(value = "/productInventory/editProduct/{id}")
	public String editProduct(@PathVariable int id, Model model) {
		// id값에 해당하는 DB 레코드 값을 모델에 매핑해 가져온다.
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);

		return "editProduct";

	}

	@RequestMapping(value = "/productInventory/editProduct", method = RequestMethod.POST)
	public String editProductPost(@Valid Product product, BindingResult result, 
			HttpServletRequest request) {

		// Spring에서 product객체에 자동 binding을 시켜줌
		if (result.hasErrors()) {
			System.out.println("===Form data has some errors===");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "editProduct";
		}

		MultipartFile productImage = product.getProductImage();
		/** 루트 디렉토리 가져오는 작업 **/
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path savePath = Paths
				.get(rootDirectory + "\\resources\\images\\uploadfile\\" + productImage.getOriginalFilename());
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(savePath.toString()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (!productService.editProduct(product)) {
			System.out.println("Editing Product cannot be done");
		}

		System.out.println(product);
		return "redirect:/admin/productInventory";

	}

}
