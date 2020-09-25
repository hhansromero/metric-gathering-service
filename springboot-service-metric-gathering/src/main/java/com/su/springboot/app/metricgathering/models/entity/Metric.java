package com.su.springboot.app.metricgathering.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "metric")
public class Metric  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "metric_id")
	private String id;
	
	@Column(name = "body_size")
	private Long bodySize;
	
	@Column(name = "start_time")
	private Long startTime;
	
	@Column(name = "end_time")
	private Long endTime;
	
	@Column(name = "duration")
	private Long requestTime;
	
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
