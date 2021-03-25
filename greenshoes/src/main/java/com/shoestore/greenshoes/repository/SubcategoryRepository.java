package com.shoestore.greenshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoestore.greenshoes.model.Subcategory;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long > {
		public List<Subcategory> findAllByDescriptionContainingIgnoreCase(String description);
		
}
