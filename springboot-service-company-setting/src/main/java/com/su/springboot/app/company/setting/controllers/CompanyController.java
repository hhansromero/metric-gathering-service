package com.su.springboot.app.company.setting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.su.springboot.app.commons.models.entity.Company;
import com.su.springboot.app.company.setting.models.service.ICompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	private ICompanyService companyService;

	@GetMapping("/list")
	public List<Company> list(){
		return companyService.findAll();
	}

	@GetMapping("/list/{id}")
	public Company detail(@PathVariable Long id) {
		return companyService.findById(id);
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Company create(@RequestBody Company company) {
		return companyService.save(company);
		
	}
	
	@PutMapping("/edit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Company edit(@RequestBody Company company, @PathVariable Long id) {
		Company companyDb = companyService.findById(id);
		
		companyDb.setName(company.getName());
		companyDb.setRuc(company.getRuc());
		companyDb.setImage(company.getImage());
		
        return companyService.save(companyDb);
	}
	
	@DeleteMapping("/remove/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		companyService.deleteById(id);
	}
	
}
