package com.su.springboot.app.metricgathering.models.entity;

import java.io.Serializable;

/**
 * MetricSummary is a model class of gathering-metric library
 * This class logs information summarized about request time and body size by HTTP operations
 * 
 * @author hector.romero
 */
public class MetricSummary  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Body size minimum of metrics
	 */
	private Long bodySizeMinimum;

	/**
	 * Body size maximum of metrics
	 */
	private Long bodySizeMaximum;
	
	/**
	 * Average of body size of metrics
	 */
	private double bodySizeAverage;

	/**
	 * Request time minimum of metrics
	 */
	private Long requestTimeMinimum;
	
	/**
	 * Request time maximum of metrics
	 */
	private Long requestTimeMaximum;
	
	/**
	 * Average of request time of metrics
	 */
	private double requestTimeAverage;
	
	/**
	 * Total records of metrics
	 */
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
