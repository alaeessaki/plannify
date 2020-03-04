package com.alae.plannify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alae.plannify.exceptions.NotFoundException;
import com.alae.plannify.model.Category;
import com.alae.plannify.services.interfaces.CategoryServiceInterface;
import com.alae.plannify.services.interfaces.EntrepriseServiceInterface;

@RestController
public class CategoryController {

	@Autowired
	CategoryServiceInterface categoyService;
	
	@Autowired
	EntrepriseServiceInterface entrepriseService;
	
	@GetMapping("api/categories")
	public ResponseEntity<List<Category>> getAll(@RequestParam("entreprise") int entreprise_id){
		entrepriseService.get(entreprise_id).orElseThrow(()->new NotFoundException("there is no entreprise with this id"));
		return ResponseEntity.ok(categoyService.findByParentIsNullAndEntrepriseId(entreprise_id));
	}
	
	@GetMapping("api/categories/{id}")
	public ResponseEntity<Category> get(@PathVariable("id")int id){
		Category category = categoyService.get(id).orElseThrow(()->new NotFoundException("there is no category with this id"));
		return ResponseEntity.ok(category);
	}
	
	@DeleteMapping("api/categories/{id}")
	public ResponseEntity<String> delete(@PathVariable("id")int id){
		categoyService.get(id).orElseThrow(()->new NotFoundException("there is no category with this id"));
		categoyService.delete(id);
		return ResponseEntity.ok("category deleted successfully");
	}
}