package com.su.springboot.app.company.setting.controllers;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.su.springboot.app.metricgathering.models.entity.Metric;
import com.su.springboot.app.metricgathering.models.entity.MetricSummary;
import com.su.springboot.app.metricgathering.models.service.MetricService;

@RestController
@RequestMapping("gathering")
public class MetricController {

	@Autowired
	private MetricService metricService;

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/metrics")
	public ResponseEntity<?> findAllMetrics() {     
		return ResponseEntity.ok(metricService.findAll());
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/metrics/summary")
	public ResponseEntity<?> findMetricsSummary() {

		List<Metric> metrics = metricService.findAll();
		MetricSummary summary = new MetricSummary();
		
		if(!metrics.isEmpty()) {
			Long bodySizeMin = metrics.stream().min(
					Comparator.comparing(Metric::getBodySize))
					.orElse(null).getBodySize();
			
			Long bodySizeMax = metrics.stream().max(
					Comparator.comparing(Metric::getBodySize)).
					orElse(null).getBodySize();
			
			double bodySizeAverage = metrics.stream()
					.mapToLong(Metric::getBodySize)
					.average().orElse(0);
			
			Long requestTimeMin = metrics.stream().min(
					Comparator.comparing(Metric::getRequestTime))
					.orElse(null).getRequestTime();
			
			Long requestTimeMax = metrics.stream().max(
					Comparator.comparing(Metric::getRequestTime))
					.orElse(null).getRequestTime();
			
			double requestTimeAverage = metrics.stream()
					.mapToLong(Metric::getRequestTime)
					.average().orElse(0);

			summary.setBodySizeMinimum(bodySizeMin);
			summary.setBodySizeMaximum(bodySizeMax);
			summary.setBodySizeAverage(bodySizeAverage);
			summary.setRequestTimeMinimum(requestTimeMin);
			summary.setRequestTimeMaximum(requestTimeMax);
			summary.setRequestTimeAverage(requestTimeAverage);
			summary.setRecords(metrics.size());
		}

		return ResponseEntity.ok(summary);
	}
}
