package com.jasmine.webApp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jasmine.webApp.Model.Product;
import com.jasmine.webApp.Repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo repo;

	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	public Product getProductbyId(int id) {
		return repo.findById(id).orElse(new Product());
	}

	public void addProduct(Product prod) {
		repo.save(prod);
	}

	public void updateProduct(Product prod) {
		repo.save(prod);

	}

	public void deleteProduct(int prodId) {
		repo.deleteById(prodId);

	}
}
