package com.shoestore.greenshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoestore.greenshoes.model.Subcategory;
import com.shoestore.greenshoes.repository.SubcategoryRepository;

@RestController
@RequestMapping("/subcategory")
@CrossOrigin("*")
public class SubcategoryController {
	
	
	@Autowired
	private SubcategoryRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Subcategory>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Subcategory> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/description/{description}")
	public ResponseEntity<List<Subcategory>> GetByTitulo(@PathVariable String description){
		return ResponseEntity.ok(repository.findAllByDescriptionContainingIgnoreCase(description));
	}
	
	@PostMapping ResponseEntity<Subcategory> post (@RequestBody Subcategory subcategory){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(subcategory));
	}
	
	@PutMapping ResponseEntity<Subcategory> put (@RequestBody Subcategory subcategory){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(subcategory));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

	
}
