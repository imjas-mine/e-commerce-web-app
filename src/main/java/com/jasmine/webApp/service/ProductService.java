package com.jasmine.webApp.service;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jasmine.webApp.Model.Product;
import com.jasmine.webApp.Repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo repo;

	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	public Product addProduct(Product prod, MultipartFile imageFile) throws IOException {
		prod.setImageName(imageFile.getOriginalFilename());
		prod.setImageType(imageFile.getContentType());
		prod.setImageData(imageFile.getBytes());
		return repo.save(prod);
	}

	public Product updateProduct(int id,Product prod,MultipartFile imageFile) throws IOException {
		prod.setImageData(imageFile.getBytes());
		prod.setImageName(imageFile.getOriginalFilename());
		prod.setImageType(imageFile.getContentType());
		return repo.save(prod);

	}

	public void deleteProduct(int prodId) {
		repo.deleteById(prodId);

	}

	public Product getProductById(int productId) {
		
		return repo.findById(productId).orElse(null);
	}
}
