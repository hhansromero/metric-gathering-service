package com.su.springboot.app.company.setting.service;

import java.util.List;

import com.su.springboot.app.commons.models.entity.Category;

public interface ICategoryService {

	public List<Category> findAll();
	public Category findById(Long id);
	public Category save(Category category);
	public void deleteById(Long id);
}
