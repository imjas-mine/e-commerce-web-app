package com.jasmine.webApp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jasmine.webApp.Model.Product;

@Service
public class ProductService {
	
	List<Product> products=new ArrayList<Product>( Arrays.asList(new Product(101,"cup",10),new Product(102,"pink bottle",20)));
	
	public List<Product> getProducts(){
		return products;
	}
	
	public Product getProductbyId(int id) {
		return products.stream().filter(product->product.getProductId()==id).findFirst().orElse(new Product(100,"item not found",0));
	}
	
	public void addProduct(Product prod) {
		products.add(prod);
	}
}
