package com.su.springboot.app.metricgathering.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.su.springboot.app.metricgathering.models.entity.Metric;

/**
 * Generate Metric Repository interface
 * Using CrudRepository interface for generic CRUD operations
 * @author hector.romero
 */
public interface MetricRepository extends CrudRepository<Metric, Long> {

}
