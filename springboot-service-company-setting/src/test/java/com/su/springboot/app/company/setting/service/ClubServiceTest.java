package com.su.springboot.app.company.setting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.su.springboot.app.commons.models.entity.Club;
import com.su.springboot.app.commons.models.entity.Company;
import com.su.springboot.app.company.setting.dao.ClubDao;

@RunWith(MockitoJUnitRunner.class)
public class ClubServiceTest {

	@InjectMocks
	ClubServiceImpl clubService;
	
	@Mock
	ClubDao clubDao;
    
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllClubsTest() {
		Company companyOne = new Company();
		companyOne.setId(1001L);
		companyOne.setName("Company Named One");
		companyOne.setRuc("RUC001");
		companyOne.setImage("Image for one");
		
		List<Club> clubs = new ArrayList<>();
		
		Club clubOne = new Club();
		clubOne.setId(2001L);
		clubOne.setName("Club Regatas");
		clubOne.setEmail("email@testemail.com");
		clubOne.setCompany(companyOne);
		
		Club clubTwo = new Club();
		clubTwo.setId(2002L);
		clubTwo.setName("Club Peru");
		clubTwo.setEmail("peruemail@testemail.com");
		clubTwo.setCompany(companyOne);
		
		clubs.add(clubOne);
		clubs.add(clubTwo);
		
		when(clubDao.findAll()).thenReturn(clubs);
		
		List<Club> clubList = clubService.findAll();
		
		assertEquals(2, clubList.size());
		verify(clubDao, times(1)).findAll();
	}
	
	@Test
	public void getClubByIdTest() {
		Club clubFound = new Club();
		clubFound.setId(4005L);
		clubFound.setName("Club Found");
		clubFound.setEmail("found@testemail.com");

		Optional<Club> opt = Optional.of(clubFound);

		when(clubDao.findById(4005L)).thenReturn(opt);

		Club clubObj = clubService.findById(4005L);
		
		assertEquals("found@testemail.com", clubObj.getEmail());
		verify(clubDao, times(1)).findById(4005L);

	}

}


