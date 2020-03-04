package com.alae.plannify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alae.plannify.dao.ProjectDaoInterface;
import com.alae.plannify.model.Project;
import com.alae.plannify.services.interfaces.ProjectServiceInterface;

@Service
public class ProjectService implements ProjectServiceInterface  {

	@Autowired
	ProjectDaoInterface projectDao;

	@Override
	public Project add(Project project) {
		return projectDao.save(project);
	}
	
	@Override
	public Optional<Project> get(int id){
		return projectDao.findById(id);
	}
	
	@Override
	public List<Project> getAll(){
		return projectDao.findAll();
	}
	
	@Override
	public void delete(int id) {
		projectDao.deleteById(id);
	}
}
