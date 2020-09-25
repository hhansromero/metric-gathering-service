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

import com.su.springboot.app.commons.models.entity.Company;
import com.su.springboot.app.company.setting.dao.CompanyDao;


@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceTest {

	@InjectMocks
	CompanyServiceImpl companyService;
	
	@Mock
	CompanyDao companyDao;
    
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllCompaniesTest() {
		
		List<Company> companies = new ArrayList<>();
		Company companyOne = new Company();
		companyOne.setId(1001L);
		companyOne.setName("Company Named One");
		companyOne.setRuc("RUC001");
		companyOne.setImage("Image for one");

		Company companyTwo = new Company();
		companyTwo.setId(1002L);
		companyTwo.setName("Company Named Two");
		companyTwo.setRuc("RUC002");
		companyTwo.setImage("Image for two");
		
		Company companyThree = new Company();
		companyThree.setId(1003L);
		companyThree.setName("Company Named Three");
		companyThree.setRuc("RUC003");
		companyThree.setImage("Image for three");
		
		companies.add(companyOne);
		companies.add(companyTwo);
		companies.add(companyThree);
		
		when(companyDao.findAll()).thenReturn(companies);
		
		List<Company> companyList = companyService.findAll();
		
		assertEquals(3, companyList.size());
		verify(companyDao, times(1)).findAll();
	}

	@Test
	public void getCompanyByIdTest() {
		Company companyFound = new Company();
		companyFound.setId(1005L);
		companyFound.setName("Company Found");
		companyFound.setRuc("RUC000909");
		companyFound.setImage("Image for company found");

		Optional<Company> opt = Optional.of(companyFound);

		when(companyDao.findById(1005L)).thenReturn(opt);

		Company companyObj = companyService.findById(1005L);
		
		assertEquals("Company Found", companyObj.getName());
		verify(companyDao, times(1)).findById(1005L);
	}
	
}


