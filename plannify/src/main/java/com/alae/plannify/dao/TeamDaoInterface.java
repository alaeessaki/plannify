package com.alae.plannify.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alae.plannify.model.Team;

@Repository
public interface TeamDaoInterface extends JpaRepository<Team, Integer>{

}
