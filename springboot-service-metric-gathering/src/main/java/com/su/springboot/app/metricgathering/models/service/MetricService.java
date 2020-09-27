package com.su.springboot.app.metricgathering.models.service;

import java.util.List;

import com.su.springboot.app.metricgathering.models.entity.Metric;

/**
 * Generate Metric interface
 * Containing basic methods to handle main operations
 * @author hector.romero
 */
public interface MetricService {

	public List<Metric> findAll();
	public Metric findById(Long id);
	public Metric save(Metric metric);
	public void deleteById(Long id);

}
