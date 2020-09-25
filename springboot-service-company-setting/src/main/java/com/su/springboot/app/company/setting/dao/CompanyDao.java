package com.su.springboot.app.company.setting.dao;

import org.springframework.data.repository.CrudRepository;

import com.su.springboot.app.commons.models.entity.Company;

public interface CompanyDao extends CrudRepository<Company, Long> {

}
