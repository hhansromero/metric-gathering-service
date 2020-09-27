package com.su.springboot.app.metricgathering.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.su.springboot.app.metricgathering.models.entity.Metric;
import com.su.springboot.app.metricgathering.models.repository.MetricRepository;
import com.su.springboot.app.metricgathering.models.service.MetricService;

/**
 * This class represents the concrete implementation of MetricService interface
 * For more details about interface implemented please see:
 * 		{@link com.su.springboot.app.metricgathering.models.service.MetricService}
 * Service layer to access to the repository methods of:
 * 		{@link com.su.springboot.app.metricgathering.models.repository.MetricRepository}
 * @author hector.romero
 */
@Service
public class MetricServiceImpl implements MetricService {

	@Autowired
	private MetricRepository metricRepository;

    /**
     * This method gets a list of all metrics
     * @return List<Metric>
     */
	@Override
	@Transactional(readOnly = true)
	public List<Metric> findAll() {
		return (List<Metric>) metricRepository.findAll();
	}

    /**
     * This method gets a Metric object by Id
     * @param id id attribute of Metric entity
     * @return a Metric object
     */
	@Override
	@Transactional(readOnly = true)
	public Metric findById(Long id) {
		return metricRepository.findById(id).orElse(null);
	}

    /**
     * It saves a Metric entity
     * @param metric Metric object related to persist
     */
	@Override
	@Transactional
	public Metric save(Metric metric) {
		return metricRepository.save(metric);
	}

    /**
     * This method deletes a Metric entity
     * @param id id attribute of Metric entity
     */
	@Override
	@Transactional
	public void deleteById(Long id) {
		metricRepository.deleteById(id);
	}

}
