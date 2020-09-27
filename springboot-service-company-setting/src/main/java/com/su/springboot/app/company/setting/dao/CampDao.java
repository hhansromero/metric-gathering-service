package com.su.springboot.app.company.setting.dao;

import org.springframework.data.repository.CrudRepository;

import com.su.springboot.app.commons.models.entity.Camp;

/**
 * Generate Camp DAO interface
 * Using CrudRepository interface for generic CRUD operations
 * @author hector.romero
 */
public interface CampDao extends CrudRepository<Camp, Long> {

}
