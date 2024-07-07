package com.priyanka.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.entity.Product;
import com.priyanka.repository.ProductRepository;
import com.priyanka.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	 
	@Autowired
	 private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		 if (product.getProductType() == null ||
		            product.getProductDescription() == null || product.getProductDescription().isEmpty() ||
		            product.getProductBinValue() == null || product.getProductBinValue().length() != 6 ||
		            product.getProductSubBinValue() == null || product.getProductSubBinValue().length() != 2 ||
		            product.getProductExpiry() <= 0 ||
		            product.getProductLimit() <= 0 ||
		            product.getProductPayment() <= 0 || product.getProductPayment() > 31) {
		            throw new IllegalArgumentException("All fields are mandatory to define a product with valid constraints");
		        }
		        return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
		
	}

}
