package com.su.springboot.app.company.setting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.su.springboot.app.commons.models.entity.Category;
import com.su.springboot.app.company.setting.dao.CategoryDao;

/**
 * This class represents the concrete implementation of ICategoryService interface
 * Service layer to access to the repository (DAO) methods
 * @author hector.romero
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

    /**
     * This method gets a list of all categories
     * @return List<Category>
     */
	@Override
	@Transactional(readOnly = true)
	public List<Category> findAll() {
		return (List<Category>) categoryDao.findAll();
	}

    /**
     * This method gets a Category object by Id
     * @param id id attribute of category entity
     * @return Category object
     */
	@Override
	@Transactional(readOnly = true)
	public Category findById(Long id) {
		return categoryDao.findById(id).orElse(null);
	}

    /**
     * It saves a Category entity
     * @param category Category object related to persist
     */
	@Override
	@Transactional
	public Category save(Category category) {
		return categoryDao.save(category);
	}

    /**
     * This method deletes a Category entity
     * @param id id attribute of category entity
     */
	@Override
	@Transactional
	public void deleteById(Long id) {
		categoryDao.deleteById(id);
	}

}
