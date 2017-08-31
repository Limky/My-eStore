package com.limky.web.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Product {
	private int id;
	private String name;
	private String category;
	private int price;
	private String manufacturer;
	private int unitInStock;
	private String description;
	
}
