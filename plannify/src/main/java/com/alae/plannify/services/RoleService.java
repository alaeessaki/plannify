package com.alae.plannify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alae.plannify.dao.RoleDaoInterface;
import com.alae.plannify.model.Role;
import com.alae.plannify.services.interfaces.RoleServiceInterface;

@Service
public class RoleService implements RoleServiceInterface {

	@Autowired
	RoleDaoInterface roleDao;
	
	@Override
	public Role add(Role role) {
		return roleDao.save(role);
	}
	
	@Override
	public Optional<Role> get(int id){
		return roleDao.findById(id);
	}
	
	@Override
	public List<Role> getAll(){
		return roleDao.findAll();
	}
	
	@Override
	public void delete(int id) {
		roleDao.deleteById(id);
	}
	
}
