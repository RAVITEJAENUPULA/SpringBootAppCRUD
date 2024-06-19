package com.wipro.Product.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.Product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
