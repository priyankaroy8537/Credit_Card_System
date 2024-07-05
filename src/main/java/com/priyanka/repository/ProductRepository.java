package com.priyanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priyanka.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {

}
