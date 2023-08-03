package com.pritam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pritam.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
	
}
