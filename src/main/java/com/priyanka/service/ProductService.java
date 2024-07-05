package com.priyanka.service;

import java.util.List;
import java.util.Optional;

import com.priyanka.entity.Product;

public interface ProductService {
  Product saveProduct(Product product);
  List<Product> getAllProducts();
  Optional<Product>getProductById(Long id);
  void deleteProduct(Long id);
  
}
