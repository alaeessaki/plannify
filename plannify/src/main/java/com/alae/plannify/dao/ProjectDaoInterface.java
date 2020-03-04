package com.alae.plannify.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alae.plannify.model.Project;

@Repository
public interface ProjectDaoInterface extends JpaRepository<Project, Integer>{

}
