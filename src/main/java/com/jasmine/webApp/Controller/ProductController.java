package com.jasmine.webApp.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jasmine.webApp.Model.Product;
import com.jasmine.webApp.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		System.out.println(productService.getAllProducts());
		return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/product/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable int productId) {
		Product product = productService.getProductById(productId);

		if (product != null) {

			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) {
		System.out.println(product);
		try {
			Product product2 = productService.addProduct(product, imageFile);
			return new ResponseEntity<Product>(product2, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("product/{id}/image")
	public ResponseEntity<byte[]> getImageByProductId(@PathVariable int id) {

		// more handling for checking if the product exists using try catch
		Product product = productService.getProductById(id);
		byte[] imageFile = product.getImageData();

		return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageFile);
	}
	@PutMapping("/product/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product,
			@RequestPart MultipartFile imageFile) {
		
		Product product2;
		try {
			product2 = productService.updateProduct(id,product,imageFile);
		} catch (IOException e) {
			return new ResponseEntity<String>("Failed to update",HttpStatus.BAD_REQUEST);
		}
		if(product2!=null) {
			return new ResponseEntity<String>("Updated",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Failed to update",HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		Product product=productService.getProductById(id);
		if(product!=null) {
			productService.deleteProduct(id);
			return new ResponseEntity<String>("Deleted",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("product not found",HttpStatus.NOT_FOUND);
		}
	}
}
