package com.su.springboot.app.company.setting.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.su.springboot.app.commons.models.entity.Company;
import com.su.springboot.app.company.setting.models.dao.CompanyDao;

@Service
public class CompanyServiceImpl implements ICompanyService {
	
	@Autowired
	private CompanyDao companyDao;

	@Override
	@Transactional(readOnly = true)
	public List<Company> findAll() {
		return (List<Company>) companyDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Company findById(Long id) {
		return companyDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Company save(Company company) {
		return companyDao.save(company);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		companyDao.deleteById(id);
	}

}
