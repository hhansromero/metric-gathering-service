package com.su.springboot.app.booking.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.su.springboot.app.booking.models.entity.Metric;
import com.su.springboot.app.booking.models.repository.MetricRepository;
import com.su.springboot.app.booking.models.service.MetricService;

@Service
public class MetricServiceImpl implements MetricService {

	@Autowired
	private MetricRepository metricRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Metric> findAll() {
		return (List<Metric>) metricRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Metric findById(Long id) {
		return metricRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Metric save(Metric metric) {
		return metricRepository.save(metric);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		metricRepository.deleteById(id);
	}

}
