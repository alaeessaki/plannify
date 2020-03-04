package com.alae.plannify.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alae.plannify.model.Category;

@Repository
public interface CategoryDaoInterface extends JpaRepository<Category, Integer>{
	public List<Category> findByParentIsNull();
	public List<Category> findByParentIsNullAndEntrepriseId(int id);
	public Optional<Category> findByLabel(String category_name);
}
