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

/**
 * MetricController is a controller class that handles for MetricService methods
 * This class was added in order to get metrics collected on HTTP lifecycle of the web application
 * It is the only class added explicitly and the goal is expose metrics
 * It is considered as a extension controller of the web application
 * For more details please see:
 * {@link com.su.springboot.app.metricgathering.models.entity.Metric} class
 * {@link com.su.springboot.app.metricgathering.models.entity.MetricSummary} class
 * @author hector.romero
 */
@RestController
@RequestMapping("gathering")
public class MetricController {

	@Autowired
	private MetricService metricService;

	/**
	 * <p>This is a method to get all metrics collected
	 *    A method of MetricServic interface of gathering-metric library is used
	 * </p>
	 * @return a list of metrics
	 * @since 1.0
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/metrics")
	public ResponseEntity<?> findAllMetrics() {     
		return ResponseEntity.ok(metricService.findAll());
	}

	/**
	 * <p>This is a method to get a summary of metrics collected
	 *    A method of MetricServic interface of gathering-metric library is used
	 * </p>
	 * @return a MetricSummary object filled
	 * @since 1.0
	 */
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
