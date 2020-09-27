package com.su.springboot.app.company.setting.service;

import java.util.List;

import com.su.springboot.app.commons.models.entity.Club;

/**
 * Generate Club interface
 * @author hector.romero
 */
public interface IClubService {

	public List<Club> findAll();
	public Club findById(Long id);
	public Club save(Club club);
	public void deleteById(Long id);
}
