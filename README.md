# metric-gathering-service
This project includes an architecture based on microservices and a part in React to consume the REST API endpoints.

It is a service to handle metrics about HTTP request and responses in a web application.
The web application is based in microservices arquitecture for backend and has a frontend module based in React.

## Backend Components
-- springboot-service-commons: Java Library with business entities (Spring DATA JPA)
-- springboot-service-config-server: Contains configuration based in Spring Cloud Config Server
-- springboot-service-eureka-server: It manages the auto discovery of services
-- springboot-service-company-setting: It has businees logic used to map the metrics
-- springboot-service-gathering-metric: It traces request and respones and persist these information in a database in memory

## Frontend Component
-- react-api: It contains a page to load the business data (Company Entity) and metric data collected (Metric List and Metric Summary)

## Start Projects
1. Download backend projects.
2. Execute command "mvnw.cmd install" at the root path of springboot-service-commons in order to install the library in local maven.
3. Startup each microservice in the following order: config-server, eureka-server, company-setting and gathering-metric.
   At this time you can test every available resources on company-setting and gathering-metric.
   Examples:
    * POST: localhost:8002/gathering/company
	{
		"name": "Sporting Cristal Camp",
		"ruc": "12345678901",
		"image": "IMAGE base 64",
		"createdBy": "1"
	}
	* GET: localhost:8002/gathering/company
	
	Each endpoint is able to save metrics of call in a H2 databse (in memory).
	If you want to see the metrics collected you can use the following endpoints:
	* GET: localhost:8002/metrics
	* GET: localhost:8002/metrics/summary
	
4. Download React Project.
5. Go to the root path of react-api/ and execute from a npm console "npm start" (example: git bash).
6. It will start up a browser in http://localhost:3000/
   The default page constains:
   *A list of companies created by default (you can add more records using a REST Client).
   *You can use the "List Companies" button to collect metrics.
   *You can use "Refresh Metrics" button to see metrics updated.
	
