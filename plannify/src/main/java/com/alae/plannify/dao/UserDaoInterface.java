package com.alae.plannify.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alae.plannify.model.User;

@Repository
public interface UserDaoInterface extends JpaRepository<User, Integer>{

}
