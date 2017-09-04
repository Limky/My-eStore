package com.limky.web.model;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Product {
	private int id;
	
	@NotEmpty(message="The product name must not be null")
	private String name;
	private String category;
	
	@Min(value=0, message="The product price must be less than zero")
	private int price;
	
	@NotEmpty(message="The product manufacturer must not be null")
	private String manufacturer;
	
	@Min(value=0, message="The product price must be less than zero")
	private int unitInStock;
	private String description;
	
	private MultipartFile productImage;
	private String imageFilename;
	
}
