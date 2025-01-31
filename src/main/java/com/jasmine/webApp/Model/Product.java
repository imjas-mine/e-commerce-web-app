package com.jasmine.webApp.Model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class Product {
	private int productId;
	private String productname;
	private int price;

	public Product() {

	}

	public Product(int productId, String productname, int price) {
		this.productId = productId;
		this.productname = productname;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String toString() {
		return "Product{" + "prodId " + productId + " prodName " + productname + " price " + price + "}";
	}
}
