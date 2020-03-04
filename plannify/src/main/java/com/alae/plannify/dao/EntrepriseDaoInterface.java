package com.alae.plannify.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alae.plannify.model.Entreprise;

@Repository
public interface EntrepriseDaoInterface extends JpaRepository<Entreprise, Integer>{

}
