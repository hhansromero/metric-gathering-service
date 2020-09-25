package com.su.springboot.app.metricgathering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.su.springboot.app.metricgathering.models.service.impl.MetricServiceInterceptor;

@Component
public class MetricServiceInterceptorAppConfig implements WebMvcConfigurer {

	@Autowired
	MetricServiceInterceptor metricServiceInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(metricServiceInterceptor);
	}

}