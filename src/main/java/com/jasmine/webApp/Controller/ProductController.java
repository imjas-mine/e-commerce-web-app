package com.jasmine.webApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jasmine.webApp.Model.Product;
import com.jasmine.webApp.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping("/")
	public String greet() {
		return "hello jasmine";
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		System.out.println(productService.getAllProducts());
		return productService.getAllProducts();
	}

	@GetMapping("/products/{prodId}")
	public Product getProductbyId(@PathVariable int prodId) {
		return productService.getProductbyId(prodId);
	}

	@PostMapping("/products")
	public void addProduct(@RequestBody Product prod) {
		productService.addProduct(prod);
	}

	@PutMapping("/products")
	public void updateProduct(@RequestBody Product prod) {
		productService.updateProduct(prod);
	}

	@DeleteMapping("/products/{prodId}")
	public void deleteProduct(@PathVariable int prodId) {
		productService.deleteProduct(prodId);
	}
}
