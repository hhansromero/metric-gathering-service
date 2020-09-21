import React, {Component} from 'react';
import Metrics from './components/metrics';
import MetricSummary from './components/metricSummary';
import Companies from './components/companies';

class App extends Component {
  constructor (props) {
    super(props);
    this.state = {
      companies: [],
      metrics: [],
      metricSummary: []
    }
    this.loadAllMetrics = this.loadAllMetrics.bind(this);
    this.loadAllCompanies = this.loadAllCompanies.bind(this);
  }

  componentDidMount() {
    this.loadAllMetrics();
    this.loadAllCompanies();
  }

  loadAllMetrics () {
    fetch('http://localhost:8002/metrics')
    .then(res => res.json())
    .then((data) => {
      this.setState({ metrics: data })
    })
    .catch(console.log);

    fetch('http://localhost:8002/metrics/summary')
    .then(res => res.json())
    .then((data) => {
      this.setState({ metricSummary: data })
    })
    .catch(console.log);
  }

  loadAllCompanies () {
    fetch('http://localhost:8002/gathering/company')
    .then(res => res.json())
    .then((data) => {
      this.setState({ companies: data })
    })
    .catch(console.log);
  }

  render () {
    return (
      <div>
        <center>
          <button id="list" onClick={this.loadAllCompanies}>List Companies (Gathering Metrics)</button>
        </center>
        <Companies companies={this.state.companies} />
        <center>
          <button id="refresh" onClick={this.loadAllMetrics}>Refresh Metrics</button>
        </center>
        <MetricSummary metricSummary={this.state.metricSummary} />
        <Metrics metrics={this.state.metrics} />
      </div>
    );
  }
}

export default App;
