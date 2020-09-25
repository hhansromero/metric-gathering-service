package com.su.springboot.app.company.setting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.su.springboot.app.commons.models.entity.Camp;
import com.su.springboot.app.company.setting.dao.CampDao;

@Service
public class CampServiceImpl implements ICampService {
	
	@Autowired
	private CampDao campDao;

	@Override
	@Transactional(readOnly = true)
	public List<Camp> findAll() {
		return (List<Camp>) campDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Camp findById(Long id) {
		return campDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Camp save(Camp camp) {
		return campDao.save(camp);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		campDao.deleteById(id);
	}

}
