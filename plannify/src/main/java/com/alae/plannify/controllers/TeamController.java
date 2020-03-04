package com.alae.plannify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alae.plannify.exceptions.NotFoundException;
import com.alae.plannify.model.Team;
import com.alae.plannify.services.interfaces.TeamServiceInterface;

@RestController
public class TeamController {

	@Autowired
	TeamServiceInterface teamService;
	
	@GetMapping("/api/teams")
	public ResponseEntity<List<Team>> getAll(){
		return ResponseEntity.ok(teamService.getAll());
	}
	
	@GetMapping("/api/teams/{id}")
	public ResponseEntity<Team> get(@PathVariable("id")int id){
		Team team = teamService.get(id).orElseThrow(()->new NotFoundException("there is no team with this id"));
		return ResponseEntity.ok(team);
	}
	
	@DeleteMapping("/api/teams/{id}")
	public ResponseEntity<String> delete(@PathVariable("id")int id){
		teamService.get(id).orElseThrow(()->new NotFoundException("there is no team with this id"));
		teamService.delete(id);
		return ResponseEntity.ok("team deleted successfully");
	}
}
