package com.su.springboot.app.metricgathering.models.service;

import java.util.List;

import com.su.springboot.app.metricgathering.models.entity.Metric;

public interface MetricService {

	public List<Metric> findAll();
	public Metric findById(Long id);
	public Metric save(Metric metric);
	public void deleteById(Long id);

}
