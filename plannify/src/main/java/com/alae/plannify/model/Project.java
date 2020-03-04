package com.alae.plannify.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "projects")
@EqualsAndHashCode(callSuper=false)
@Data
public class Project extends Audit{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private int id;
	
	@NotBlank(message = "nom cannot be null")
	@Column(name = "nom")
	private String nom;
	
	@NotBlank(message = "description cannot be null")
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	
	@ManyToMany(mappedBy = "projects")
	private List<Team> teams;
	
}
