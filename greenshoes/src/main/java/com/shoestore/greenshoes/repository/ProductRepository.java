package com.shoestore.greenshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoestore.greenshoes.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	public List<Product> findAllByNameContainingIgnoreCase(String name);
}
