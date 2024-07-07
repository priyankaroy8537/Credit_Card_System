package com.priyanka.service;

import java.util.List;
import java.util.Optional;

import com.priyanka.entity.Product;

public interface ProductService {
	Product saveProduct(Product product); // Method to save a product
    List<Product> getAllProducts(); // Method to get all products
    Optional<Product> getProductById(Long id); // Method to get a product by ID
    void deleteProduct(Long id);
}
