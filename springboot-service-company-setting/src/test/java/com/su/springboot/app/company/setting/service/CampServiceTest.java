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

import com.su.springboot.app.commons.models.entity.Camp;
import com.su.springboot.app.commons.models.entity.Category;
import com.su.springboot.app.company.setting.dao.CampDao;


@RunWith(MockitoJUnitRunner.class)
public class CampServiceTest {

	@InjectMocks
	CampServiceImpl campService;
	
	@Mock
	CampDao campDao;
    
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllCampsTest() {
		
		Category categoryFootball = new Category();
		categoryFootball.setId(3001L);
		categoryFootball.setName("Football");
		
		List<Camp> camps= new ArrayList<>();
		Camp campOne = new Camp();
		campOne.setId(1001L);
		campOne.setName("River Plate Camp");
		campOne.setDescription("Main River Plate camp located in Buenos Aires");
		campOne.setCategory(categoryFootball);
		
		Camp campTwo = new Camp();
		campTwo.setId(1002L);
		campTwo.setName("River Plate Mendoza");
		campTwo.setDescription("Alternative River Plate camp located in Mendoza");
		campTwo.setCategory(categoryFootball);
		
		Camp campThree = new Camp();
		campThree.setId(1001L);
		campThree.setName("Boca Junios Camp");
		campThree.setDescription("Main Boca Juniors camp located in Buenos Aires");
		campThree.setCategory(categoryFootball);
		
		camps.add(campOne);
		camps.add(campTwo);
		camps.add(campThree);
		
		when(campDao.findAll()).thenReturn(camps);
		
		List<Camp> campList = campService.findAll();
		
		assertEquals(3, campList.size());
		verify(campDao, times(1)).findAll();
	}

	@Test
	public void getCampByIdTest() {
		Camp campFound = new Camp();
		campFound.setId(5005L);
		campFound.setName("Regatas");
		campFound.setDescription("Camp of Club Regatas");

		Optional<Camp> opt = Optional.of(campFound);

		when(campDao.findById(5005L)).thenReturn(opt);

		Camp campObj = campService.findById(5005L);
		
		assertEquals("Regatas", campObj.getName());
		verify(campDao, times(1)).findById(5005L);
	}
	
}


