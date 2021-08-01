package com.phoenix.entities;
/*
 * @author: bhargav.parmar@stltech.in
 * @Version: 1.0.0
 * @Date: 7-Jul-2021
 * @Copyright: Sterlite Technology Ltd.
 * @Discription: It is a POJO class which acts as a 
 * 					Persistent class or Entity class 
 * 					in Hibernate
 */

public class Product {
	
	//attribute or instance variable
	private int productId;
	private String productName;
	private String brand;
	private float price;
	
	//Parameterized
	public Product(int productId, String productName, String brand, float price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.brand = brand;
		this.price = price;
	}
	
	//Default
	public Product() {
		super();
	}
	
	//Getters and Setter
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	//ToString method
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", brand=" + brand + ", price="
				+ price + "]";
	}
} //end of class
 