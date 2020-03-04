package com.alae.plannify.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.alae.plannify.model.User;

public interface UserServiceInterface {

	User add(User user);

	Optional<User> get(int id);

	List<User> getAll();

	void delete(int id);
	
	List<User> addMany(List<User> users);

}