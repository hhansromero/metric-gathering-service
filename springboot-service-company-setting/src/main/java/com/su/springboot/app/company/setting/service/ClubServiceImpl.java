package com.su.springboot.app.company.setting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.su.springboot.app.commons.models.entity.Club;
import com.su.springboot.app.company.setting.dao.ClubDao;

@Service
public class ClubServiceImpl implements IClubService {
	
	@Autowired
	private ClubDao clubDao;

	@Override
	@Transactional(readOnly = true)
	public List<Club> findAll() {
		return (List<Club>) clubDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Club findById(Long id) {
		return clubDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Club save(Club club) {
		return clubDao.save(club);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		clubDao.deleteById(id);
	}

}
