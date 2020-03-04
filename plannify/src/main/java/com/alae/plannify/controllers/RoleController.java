package com.alae.plannify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alae.plannify.exceptions.NotFoundException;
import com.alae.plannify.model.Role;
import com.alae.plannify.services.interfaces.RoleServiceInterface;

@RestController
public class RoleController {

	@Autowired
	RoleServiceInterface roleService;

	@GetMapping("/api/admin/roles")
	public ResponseEntity<List<Role>> getAll(){
		return ResponseEntity.ok(roleService.getAll());
	}
	
	@GetMapping("/api/admin/roles/{id}")
	public ResponseEntity<Role> get(@PathVariable("id")int id){
		Role role = roleService.get(id).orElseThrow(()->new NotFoundException("there is no role with this id "));
		return ResponseEntity.ok(role);
	}
	
	@DeleteMapping("/api/admin/roles/{id}")
	public ResponseEntity<String> delete(@PathVariable("id")int id){
		roleService.get(id).orElseThrow(()->new NotFoundException("there is no role with this id "));
		roleService.delete(id);
		return ResponseEntity.ok("role deleted successfully");
	}
}
