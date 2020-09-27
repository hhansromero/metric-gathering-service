package com.su.springboot.app.company.setting.service;

import java.util.List;

import com.su.springboot.app.commons.models.entity.Company;

/**
 * Generate Company interface
 * @author hector.romero
 */
public interface ICompanyService {

	public List<Company> findAll();
	public Company findById(Long id);
	public Company save(Company company);
	public void deleteById(Long id);
}
