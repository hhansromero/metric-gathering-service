package com.su.springboot.app.metricgathering.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Metric is a business entity of gathering-metric library
 * This class logs information about request time and body size by HTTP operations
 * 
 * @author hector.romero
 */
@Entity
@Table(name = "metric")
public class Metric  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * The identifier of the metric
	 */
	@Id
	@Column(name = "metric_id")
	private String id;

	/**
	 * The body size of response
	 */
	@Column(name = "body_size")
	private Long bodySize;

	/**
	 * The start time of request
	 */
	@Column(name = "start_time")
	private Long startTime;
	
	/**
	 * The end time before send to client response
	 */
	@Column(name = "end_time")
	private Long endTime;
	
	/**
	 * The request time calculated
	 */
	@Column(name = "duration")
	private Long requestTime;

	/**
	 * The HTTP method of the operation
	 */
	@Column(name = "method_type", length = 6)
	private String methodType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getBodySize() {
		return bodySize;
	}

	public void setBodySize(Long bodySize) {
		this.bodySize = bodySize;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public Long getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Long requestTime) {
		this.requestTime = requestTime;
	}

	public String getMethodType() {
		return methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

}
