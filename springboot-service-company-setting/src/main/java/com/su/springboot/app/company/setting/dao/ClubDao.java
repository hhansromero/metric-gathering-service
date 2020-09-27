package com.su.springboot.app.company.setting.dao;

import org.springframework.data.repository.CrudRepository;

import com.su.springboot.app.commons.models.entity.Club;

/**
 * Generate Club DAO interface
 * Using CrudRepository interface for generic CRUD operations
 * @author hector.romero
 */
public interface ClubDao extends CrudRepository<Club, Long> {

}
