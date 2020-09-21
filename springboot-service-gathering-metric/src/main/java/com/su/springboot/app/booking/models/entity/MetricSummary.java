package com.su.springboot.app.booking.models.entity;

import java.io.Serializable;

public class MetricSummary  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long bodySizeMinimum;
	private Long bodySizeMaximum;
	private double bodySizeAverage;
	private Long durationMinimum;
	private Long durationMaximum;
	private double durationAverage;
	private int totalRecords;
	
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
	public Long getDurationMinimum() {
		return durationMinimum;
	}
	public void setDurationMinimum(Long durationMinimum) {
		this.durationMinimum = durationMinimum;
	}
	public Long getDurationMaximum() {
		return durationMaximum;
	}
	public void setDurationMaximum(Long durationMaximum) {
		this.durationMaximum = durationMaximum;
	}
	public double getDurationAverage() {
		return durationAverage;
	}
	public void setDurationAverage(double durationAverage) {
		this.durationAverage = durationAverage;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

}
