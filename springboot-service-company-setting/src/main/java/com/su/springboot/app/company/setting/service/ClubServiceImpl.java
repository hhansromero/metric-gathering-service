package com.su.springboot.app.company.setting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.su.springboot.app.commons.models.entity.Club;
import com.su.springboot.app.company.setting.dao.ClubDao;

/**
 * This class represents the concrete implementation of IClubService interface
 * Service layer to access to the repository (DAO) methods
 * @author hector.romero
 */
@Service
public class ClubServiceImpl implements IClubService {
	
	@Autowired
	private ClubDao clubDao;

    /**
     * This method gets a list of all clubs
     * @return List<Club>
     */
	@Override
	@Transactional(readOnly = true)
	public List<Club> findAll() {
		return (List<Club>) clubDao.findAll();
	}

    /**
     * This method gets a Club object by Id
     * @param id id attribute of club entity
     * @return Club object
     */
	@Override
	@Transactional(readOnly = true)
	public Club findById(Long id) {
		return clubDao.findById(id).orElse(null);
	}

    /**
     * It saves a Club entity
     * @param club Club object related to persist
     */
	@Override
	@Transactional
	public Club save(Club club) {
		return clubDao.save(club);
	}

    /**
     * This method deletes a Club entity
     * @param id id attribute of club entity
     */
	@Override
	@Transactional
	public void deleteById(Long id) {
		clubDao.deleteById(id);
	}

}
