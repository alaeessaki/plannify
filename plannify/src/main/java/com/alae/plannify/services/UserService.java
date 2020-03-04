package com.alae.plannify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alae.plannify.dao.UserDaoInterface;
import com.alae.plannify.model.User;
import com.alae.plannify.services.interfaces.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	UserDaoInterface userDao;
	
	@Override
	public User add(User user) {
		return userDao.save(user);
	}
	
	@Override
	public Optional<User> get(int id){
		return userDao.findById(id);
	}
	
	@Override
	public List<User> getAll(){
		return userDao.findAll();
	}
	
	@Override
	public void delete(int id) {
		userDao.deleteById(id);
	}
	
	@Override
	public List<User> addMany(List<User> users) {
		return userDao.saveAll(users);
	}
}	