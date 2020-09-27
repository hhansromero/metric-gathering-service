package com.su.springboot.app.company.setting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.su.springboot.app.commons.models.entity.Camp;
import com.su.springboot.app.company.setting.dao.CampDao;

/**
 * This class represents the concrete implementation of ICampService interface
 * Service layer to access to the repository (DAO) methods
 * @author hector.romero
 */
@Service
public class CampServiceImpl implements ICampService {
	
	@Autowired
	private CampDao campDao;

    /**
     * This method gets a list of all camps
     * @return List<Camp>
     */
	@Override
	@Transactional(readOnly = true)
	public List<Camp> findAll() {
		return (List<Camp>) campDao.findAll();
	}

    /**
     * This method gets a Camp object by Id
     * @param id id attribute of camp entity
     * @return Camp object
     */
	@Override
	@Transactional(readOnly = true)
	public Camp findById(Long id) {
		return campDao.findById(id).orElse(null);
	}

    /**
     * It saves a Camp entity
     * @param camp Camp object related to persist
     */
	@Override
	@Transactional
	public Camp save(Camp camp) {
		return campDao.save(camp);
	}

    /**
     * This method deletes a Camp entity
     * @param id id attribute of camp entity
     */
	@Override
	@Transactional
	public void deleteById(Long id) {
		campDao.deleteById(id);
	}

}
