import React from 'react'

const Metrics = ({ metrics }) => {
  return (
    <div>
      <center><h1>Metric List</h1></center>
      {metrics.map((metric) => (
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Metric Entry Id: {metric.id}</h5>
            <h6 class="card-subtitle mb-2 text-muted">Start time (Miliseconds): {metric.startTime}</h6>
            <h6 class="card-subtitle mb-2 text-muted">End time (Miliseconds): {metric.endTime}</h6>
            <h6 class="card-subtitle mb-2 text-muted">Duration (Miliseconds): {metric.duration}</h6>
            <p class="card-text">Method Type: {metric.methodType}</p>
            <p class="card-text">Body Size (Bytes): {metric.bodySize}</p>
          </div>
        </div>
      ))}
    </div>

  )
};

export default Metrics