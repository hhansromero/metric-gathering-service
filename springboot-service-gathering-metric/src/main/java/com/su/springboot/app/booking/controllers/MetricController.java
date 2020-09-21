package com.su.springboot.app.booking.controllers;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.su.springboot.app.booking.models.entity.Metric;
import com.su.springboot.app.booking.models.entity.MetricSummary;
import com.su.springboot.app.booking.models.service.MetricService;

@RestController
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
			
			Long durationMin = metrics.stream().min(
					Comparator.comparing(Metric::getDuration))
					.orElse(null).getDuration();
			
			Long durationMax = metrics.stream().max(
					Comparator.comparing(Metric::getDuration))
					.orElse(null).getDuration();
			
			double durationAverage = metrics.stream()
					.mapToLong(Metric::getDuration)
					.average().orElse(0);

			summary.setBodySizeMinimum(bodySizeMin);
			summary.setBodySizeMaximum(bodySizeMax);
			summary.setBodySizeAverage(bodySizeAverage);
			summary.setDurationMinimum(durationMin);
			summary.setDurationMaximum(durationMax);
			summary.setDurationAverage(durationAverage);
			summary.setTotalRecords(metrics.size());
		}

		return ResponseEntity.ok(summary);
	}
}
