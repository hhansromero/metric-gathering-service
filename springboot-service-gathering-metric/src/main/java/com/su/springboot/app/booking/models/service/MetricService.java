package com.su.springboot.app.booking.models.service;

import java.util.List;

import com.su.springboot.app.booking.models.entity.Metric;

public interface MetricService {

	public List<Metric> findAll();
	public Metric findById(Long id);
	public Metric save(Metric metric);
	public void deleteById(Long id);

}
