package com.su.springboot.app.company.setting.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.su.springboot.app.commons.models.entity.Category;

public interface CategoryDao extends CrudRepository<Category, Long> {

}
