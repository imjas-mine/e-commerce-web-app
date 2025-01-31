package com.jasmine.webApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jasmine.webApp.Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	
}
