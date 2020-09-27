package com.su.springboot.app.company.setting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.su.springboot.app.commons.models.entity.Company;
import com.su.springboot.app.company.setting.service.ICompanyService;

/**
 * CompanyController is a controller class that handles for CompanyService methods
 * Company is a business entity of the web application and it is used in this class
 * For more details please see the {@link com.su.springboot.app.commons.models.entity.Company} class
 * @author hector.romero
 */
@RestController
@RequestMapping("company")
public class CompanyController {
	
	@Autowired
	private ICompanyService companyService;

	/**
	 * <p>This is a method to get the list of companies from a service method
	 * </p>
	 * @return the list of companies
	 * @since 1.0
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/list")
	public List<Company> list(){
		return companyService.findAll();
	}

	/**
	 * <p>This is a method to get a company from a service method
	 * </p>
	 * @param id identifier of a company
	 * @return a company obtained by an id
	 * @since 1.0
	 */
	@GetMapping("/list/{id}")
	public Company detail(@PathVariable Long id) {
		return companyService.findById(id);
	}

	/**
	 * <p>This is a method to save a company through a service method
	 * </p>
	 * @param company a company object 
	 * @return the company created
	 * @since 1.0
	 */
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Company create(@RequestBody Company company) {
		return companyService.save(company);
		
	}

	/**
	 * <p>This is a method to update a company through a service method
	 * </p>
	 * @param company a company object
	 * @param id identifier of a company 
	 * @return the company modified
	 * @since 1.0
	 */
	@PutMapping("/edit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Company edit(@RequestBody Company company, @PathVariable Long id) {
		Company companyDb = companyService.findById(id);
		
		companyDb.setName(company.getName());
		companyDb.setRuc(company.getRuc());
		companyDb.setImage(company.getImage());
		
        return companyService.save(companyDb);
	}

	/**
	 * <p>This is a method to remove a company through a service method
	 * </p>
	 * @param id identifier of a company
	 * @since 1.0
	 */
	@DeleteMapping("/remove/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		companyService.deleteById(id);
	}
	
}
