package com.su.springboot.app.company.setting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.su.springboot.app.commons.models.entity.Company;
import com.su.springboot.app.company.setting.dao.CompanyDao;

/**
 * @author hector.romero
 * This class represents the concrete implementation of ICompanyService interface
 * Service layer to access to the repository (DAO) methods
 */
@Service
public class CompanyServiceImpl implements ICompanyService {
	
	@Autowired
	private CompanyDao companyDao;

    /**
     * This method gets a list of all companies
     * @return List<Company>
     */
	@Override
	@Transactional(readOnly = true)
	public List<Company> findAll() {
		return (List<Company>) companyDao.findAll();
	}

    /**
     * This method gets a Company object by Id
     * @param id id attribute of company entity
     * @return Company object
     */
	@Override
	@Transactional(readOnly = true)
	public Company findById(Long id) {
		return companyDao.findById(id).orElse(null);
	}

    /**
     * It saves a Company entity
     * @param company Company object related to persist
     */
	@Override
	@Transactional
	public Company save(Company company) {
		return companyDao.save(company);
	}

    /**
     * This method deletes a Company entity
     * @param id id attribute of company entity
     */
	@Override
	@Transactional
	public void deleteById(Long id) {
		companyDao.deleteById(id);
	}

}
