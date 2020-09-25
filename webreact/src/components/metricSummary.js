import React from 'react'

const MetricSummary = ({ metricSummary }) => {
  return (
    <div>
      <center><h1>Metric Summary</h1></center>
        <div class="card">
          <div class="card-body">
            <h6 class="card-subtitle mb-2 text-muted">Request Time Minimum: {metricSummary.requestTimeMinimum}</h6>
            <h6 class="card-subtitle mb-2 text-muted">Request Time Maximum: {metricSummary.requestTimeMaximum}</h6>
            <h6 class="card-subtitle mb-2 text-muted">Request Time Average: {metricSummary.requestTimeAverage}</h6>
            <h6 class="card-subtitle mb-2 text-muted">Response Body Size Minimum: {metricSummary.bodySizeMinimum}</h6>
            <h6 class="card-subtitle mb-2 text-muted">Response Body Size Maximum: {metricSummary.bodySizeMaximum}</h6>
            <h6 class="card-subtitle mb-2 text-muted">Response Body Size Average: {metricSummary.bodySizeAverage}</h6>
            <h6 class="card-text">Total Records: {metricSummary.records}</h6>
          </div>
        </div>
    </div>

  )
};

export default MetricSummary