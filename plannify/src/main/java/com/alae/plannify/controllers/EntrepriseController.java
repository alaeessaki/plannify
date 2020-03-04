package com.alae.plannify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alae.plannify.exceptions.NotFoundException;
import com.alae.plannify.model.Entreprise;
import com.alae.plannify.services.interfaces.EntrepriseServiceInterface;

@RestController
public class EntrepriseController {

	@Autowired
	EntrepriseServiceInterface entrepriseService;

	@GetMapping("/api/admin/entreprises")
	public ResponseEntity<List<Entreprise>> getAll(){
		return ResponseEntity.ok(entrepriseService.getAll());
	}
	
	@GetMapping("/api/admin/entreprises/{id}")
	public ResponseEntity<Entreprise> get(@PathVariable("id")int id){
		Entreprise entreprise = entrepriseService.get(id).orElseThrow(()->new NotFoundException("there is no entreprise with this id"));
		return ResponseEntity.ok(entreprise);
	}
	
	@DeleteMapping("/api/admin/entreprises/{id}")
	public ResponseEntity<String> delete(@PathVariable("id")int id){
		entrepriseService.get(id).orElseThrow(()->new NotFoundException("there is no entreprise with this id"));	
		entrepriseService.delete(id);
		return ResponseEntity.ok("entreprise deleted successfully");
	}
}
