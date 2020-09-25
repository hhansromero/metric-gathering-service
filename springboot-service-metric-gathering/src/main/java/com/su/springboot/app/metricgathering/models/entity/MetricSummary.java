package com.su.springboot.app.metricgathering.models.entity;

import java.io.Serializable;

public class MetricSummary  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long bodySizeMinimum;
	private Long bodySizeMaximum;
	private double bodySizeAverage;
	private Long requestTimeMinimum;
	private Long requestTimeMaximum;
	private double requestTimeAverage;
	private int records;

	public Long getBodySizeMinimum() {
		return bodySizeMinimum;
	}
	public void setBodySizeMinimum(Long bodySizeMinimum) {
		this.bodySizeMinimum = bodySizeMinimum;
	}
	public Long getBodySizeMaximum() {
		return bodySizeMaximum;
	}
	public void setBodySizeMaximum(Long bodySizeMaximum) {
		this.bodySizeMaximum = bodySizeMaximum;
	}
	public double getBodySizeAverage() {
		return bodySizeAverage;
	}
	public void setBodySizeAverage(double bodySizeAverage) {
		this.bodySizeAverage = bodySizeAverage;
	}
	public Long getRequestTimeMinimum() {
		return requestTimeMinimum;
	}
	public void setRequestTimeMinimum(Long requestTimeMinimum) {
		this.requestTimeMinimum = requestTimeMinimum;
	}
	public Long getRequestTimeMaximum() {
		return requestTimeMaximum;
	}
	public void setRequestTimeMaximum(Long requestTimeMaximum) {
		this.requestTimeMaximum = requestTimeMaximum;
	}
	public double getRequestTimeAverage() {
		return requestTimeAverage;
	}
	public void setRequestTimeAverage(double requestTimeAverage) {
		this.requestTimeAverage = requestTimeAverage;
	}
	public int getRecords() {
		return records;
	}
	public void setRecords(int records) {
		this.records = records;
	}

}
