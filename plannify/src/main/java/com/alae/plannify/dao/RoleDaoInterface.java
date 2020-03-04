package com.alae.plannify.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alae.plannify.model.Role;

@Repository
public interface RoleDaoInterface extends JpaRepository<Role, Integer>{

}
