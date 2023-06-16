package com.security.example.JWTSecurityDemo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.example.JWTSecurityDemo.entity.Product;
import com.security.example.JWTSecurityDemo.repository.ProductRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController

@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
	private final ProductRepository productRepository;
	
	@PostMapping
	public ResponseEntity<Product> create(@Valid @RequestBody Product product){
		
		
		Product saved = productRepository.save(product);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getProducts(){
		List<Product> products = productRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	

}
