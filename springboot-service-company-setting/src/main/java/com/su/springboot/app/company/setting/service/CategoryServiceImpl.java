package com.su.springboot.app.company.setting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.su.springboot.app.commons.models.entity.Category;
import com.su.springboot.app.company.setting.dao.CategoryDao;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	@Transactional(readOnly = true)
	public List<Category> findAll() {
		return (List<Category>) categoryDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Category findById(Long id) {
		return categoryDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Category save(Category category) {
		return categoryDao.save(category);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		categoryDao.deleteById(id);
	}

}
