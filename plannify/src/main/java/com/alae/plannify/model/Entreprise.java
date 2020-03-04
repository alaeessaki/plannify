package com.alae.plannify.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "entreprises")
@EqualsAndHashCode(callSuper=false)
@Data
public class Entreprise extends Audit{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "entreprise_id")
	private int id;
	
	@NotBlank(message = "nom cannot be null")
	@Column(name = "nom")
	private String nom;
	
	@NotBlank(message = "description cannot be null")
	@Column(name = "description")
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL)
	private List<User> users;
	
	@JsonIgnore
	@OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL)
	private List<Team> teams;
	
	@OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL)
	private List<Category> categories;
}