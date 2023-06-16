package com.security.example.JWTSecurityDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.example.JWTSecurityDemo.entity.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{

}
