package com.alae.plannify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alae.plannify.dao.CategoryDaoInterface;
import com.alae.plannify.model.Category;
import com.alae.plannify.services.interfaces.CategoryServiceInterface;

@Service
public class CategoryService implements CategoryServiceInterface  {
	
	@Autowired
	CategoryDaoInterface categoryDao;
	

	@Override
	public Category add(Category category) {
		return categoryDao.save(category);
	}
	

	@Override
	public Optional<Category> get(int id){
		return categoryDao.findById(id);
	}
	
	
	@Override
	public List<Category> getAll(){
		return categoryDao.findAll();
	}
	
	@Override
	public void delete(int id) {
		categoryDao.deleteById(id);
	}
	
	@Override
	public Optional<Category> findByLabel(String category_name) {
		return categoryDao.findByLabel(category_name);
	}
	
	@Override
	public List<Category> findByParentIsNull() {
		return categoryDao.findByParentIsNull();
	}
	
	@Override
	public List<Category> findByParentIsNullAndEntrepriseId(int id) {
		return categoryDao.findByParentIsNullAndEntrepriseId(id);
	}
}
