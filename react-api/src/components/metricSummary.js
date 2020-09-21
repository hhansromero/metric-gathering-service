import React from 'react'

const MetricSummary = ({ metricSummary }) => {
  return (
    <div>
      <center><h1>Metric Summary</h1></center>
        <div class="card">
          <div class="card-body">
            <h6 class="card-subtitle mb-2 text-muted">Duration Minimum: {metricSummary.durationMinimum}</h6>
            <h6 class="card-subtitle mb-2 text-muted">Duration Maximum: {metricSummary.durationMaximum}</h6>
            <h6 class="card-subtitle mb-2 text-muted">Duration Average: {metricSummary.durationAverage}</h6>
            <h6 class="card-subtitle mb-2 text-muted">Body Size Minimum: {metricSummary.bodySizeMinimum}</h6>
            <h6 class="card-subtitle mb-2 text-muted">Body Size Maximum: {metricSummary.bodySizeMaximum}</h6>
            <h6 class="card-subtitle mb-2 text-muted">Body Size Average: {metricSummary.bodySizeAverage}</h6>
            <h6 class="card-text">Total Records: {metricSummary.totalRecords}</h6>
          </div>
        </div>
    </div>

  )
};

export default MetricSummary