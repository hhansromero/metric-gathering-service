package com.su.springboot.app.metricgathering.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.su.springboot.app.metricgathering.models.entity.Metric;

public interface MetricRepository extends CrudRepository<Metric, Long> {

}
