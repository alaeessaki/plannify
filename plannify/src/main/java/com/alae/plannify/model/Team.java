package com.alae.plannify.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "teams")
@EqualsAndHashCode(callSuper=false)
@Data
public class Team extends Audit{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private int id;
	
	@NotBlank(message = "nom cannot be null")
	@Column(name = "nom")
	private String nom;
	
	@NotBlank(message = "description cannot be null")
	@Column(name = "description")
	private String description;
	
	
	@ManyToMany(mappedBy = "teams")
	private List<User> users;
	
	@ManyToOne
	@JoinColumn(name = "entreprise_id")
	private Entreprise entreprise;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "team_project",
			joinColumns = @JoinColumn(name = "team_id"),
			inverseJoinColumns = @JoinColumn(name = "project_id")
			)
	private List<Project> projects;
}