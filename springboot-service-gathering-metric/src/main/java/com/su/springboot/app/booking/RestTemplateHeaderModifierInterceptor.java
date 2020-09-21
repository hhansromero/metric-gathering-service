package com.su.springboot.app.booking;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.su.springboot.app.booking.models.entity.Metric;
import com.su.springboot.app.booking.models.service.MetricService;

@Component
public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {

	private static Logger log = LoggerFactory.getLogger(RestTemplateHeaderModifierInterceptor.class);

	public static ApplicationContext ctx;
	
    @Autowired
    private void setApplicationContext(ApplicationContext applicationContext) {
        ctx = applicationContext;       
    }
	
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		
		log.info(String.format("%s routed to %s", request.getMethod(), request.getURI().toString()));		
		Long startTime = System.currentTimeMillis();
		
        ClientHttpResponse response = execution.execute(request, body);
        
        byte[] targetArray = new byte[response.getBody().available()];
        log.info(String.format("targetArray %s", targetArray.length));
        
		Long endTime = System.currentTimeMillis();
        Long finalTime = endTime - startTime;
        
        log.info(String.format("Final time in seconds %s", finalTime.doubleValue()/1000.00));
        log.info(String.format("Final time in miliseconds %s", finalTime));
        
        try {
            MetricService metricService = 
            		(MetricService)RestTemplateHeaderModifierInterceptor.ctx.getBean(MetricService.class);

            Metric metric = new Metric();
            metric.setBodySize(new Long(targetArray.length));
            metric.setStartTime(startTime);
            metric.setEndTime(endTime);
            metric.setDuration(finalTime);
            metric.setMethodType(request.getMethod().toString());
            metricService.save(metric);

		} catch (Exception e) {
			log.debug(e.getMessage());
		}
        return response;
	}
	
}