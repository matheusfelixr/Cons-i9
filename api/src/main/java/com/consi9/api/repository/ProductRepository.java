package com.consi9.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consi9.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
