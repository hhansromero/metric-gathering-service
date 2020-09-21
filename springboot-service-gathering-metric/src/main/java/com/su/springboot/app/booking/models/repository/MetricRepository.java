package com.su.springboot.app.booking.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.su.springboot.app.booking.models.entity.Metric;

public interface MetricRepository extends CrudRepository<Metric, Long> {

}
