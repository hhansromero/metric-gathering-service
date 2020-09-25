package com.su.springboot.app.company.setting.service;

import java.util.List;

import com.su.springboot.app.commons.models.entity.Camp;

public interface ICampService {

	public List<Camp> findAll();
	public Camp findById(Long id);
	public Camp save(Camp camp);
	public void deleteById(Long id);
}
