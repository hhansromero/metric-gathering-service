package com.su.springboot.app.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.su.springboot.app.commons.models.entity.Company;

@RestController
public class MetricGatheringController {

	@Autowired
	RestTemplate restTemplate;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/gathering/company")
	public ResponseEntity<?> findAllCompanies(){	
		return ResponseEntity.ok(restTemplate.getForObject("http://localhost:8001/list", Company[].class));
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/gathering/company")
	public ResponseEntity<?> create(@RequestBody Company company){
		return ResponseEntity.ok(restTemplate.postForObject("http://localhost:8001/create", company, Company.class));
	}

}
