package com.alae.plannify.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "roles")
@EqualsAndHashCode(callSuper=false)
@Data
public class Role extends Audit{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int id;
	
	@NotBlank(message = "label cannot be null")
	@Column(name = "label")
	private String label;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
}
