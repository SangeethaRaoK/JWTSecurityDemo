package com.security.example.JWTSecurityDemo.entity;

import org.hibernate.validator.constraints.Length;

import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="products")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	@Length(min = 5,max = 128)
	private String name;
	private double price;

}
