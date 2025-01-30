package com.jasmine.webApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jasmine.webApp.Model.Product;
import com.jasmine.webApp.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getProducts();
	}
	
	@GetMapping("/products/{prodId}")
	public Product getProductbyId(@PathVariable int prodId) {
		return productService.getProductbyId(prodId);
	}
	@PostMapping("/products")
	public void addProduct(@RequestBody Product prod) {
		productService.addProduct(prod);
	}
}
