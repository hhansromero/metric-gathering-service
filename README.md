# metric-gathering-service
This project includes an architecture based on microservices and a part in React to consume the REST API endpoints.

It is a service to handle metrics about HTTP request and responses in a web application.
The web application is based in microservices arquitecture for backend and has a frontend module based in React.

## Backend Components
- springboot-service-commons: Java Library that contains business entities (Spring DATA JPA) of the web application
- springboot-service-config-server: Contains configuration based in Spring Cloud Config Server (Web application configuration)
- springboot-service-eureka-server: It manages the auto discovery of services (Web application is registered in this server)
- springboot-service-company-setting: It has business logic of the web application
- springboot-service-metric-gathering: Java Library created in order to logging the HTTP responses by interceptors. Besides, It contains services and entities to persist metrics

## Frontend Component
- react-api: It contains a page to load the business data (Company Entity) and metric data collected (Metric List and Metric Summary)

## Start Projects
1. Download backend projects.
2. Execute command "mvnw.cmd install" at the root path of "springboot-service-commons" in order to install the library in local maven.
3. Execute command "mvnw.cmd install" at the root path of "springboot-service-metric-gathering" in order to install the library in local maven.
4. Startup each microservice in the following order: config-server, eureka-server and company-setting.
   At this time you can test every available resources on company-setting service and these should log the metrics about them.
   Examples:
        * POST: localhost:8001/company/create
	{
		"name": "Sporting Cristal Camp",
		"ruc": "12345678901",
		"image": "IMAGE base 64",
		"createdBy": "1"
	}
	* GET: localhost:8002/company/list
	
	Each endpoint is able to save metrics of calls in a H2 database (in memory).
	If you want to see the metrics collected you can use the following endpoints:
	* GET: localhost:8001/gathering/metrics
	* GET: localhost:8001/gathering/metrics/summary
	
5. Download React Project (react-api) in a separate folder of your preference.
   Steps to run:
   - 5.1 Create a new folder
   - 5.2 Start a npm window at the root of the new folder
   - 5.2 Execute: npm i create-react-app
   - 5.3 Execute: npx create-react-app react-api
   - 5.4 Replace the "src" created in step 5.3 with "src" folder downloaded in the step 5
   - 5.5 Execute (at the root of react-api): npm start
6. It will start up a browser in http://localhost:3000/. The default page constains:
   * A list of companies created by default (you can add more records using a REST Client).
   * You can use the "List Companies" button to collect metrics.
   * You can use "Refresh Metrics" button to see metrics updated.
	
