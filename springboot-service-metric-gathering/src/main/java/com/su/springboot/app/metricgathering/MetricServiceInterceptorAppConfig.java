package com.su.springboot.app.metricgathering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.su.springboot.app.metricgathering.models.service.impl.MetricServiceInterceptor;

/**
 * This is a config class to add our interceptors. This class implements WebMvcConfigurer which adds the interceptor within the addInterceptors method
 * Interceptors can be registered to apply to all requests or be limited to a subset of URL patterns
 * In this library the interceptor is used to fetch metrics
 * Metrics include counts data to log the latency of our ecosystem
 *
 * The events of lifecycle interceptors for pre- and post-processing of controller method invocations are located in:
 * 		{@link com.su.springboot.app.metricgathering.models.service.impl.MetricServiceInterceptor}
 * @author hector.romero
 */
@Component
public class MetricServiceInterceptorAppConfig implements WebMvcConfigurer {

	@Autowired
	MetricServiceInterceptor metricServiceInterceptor;

    /**
     * This method enables the metricServiceInterceptor bean configured
     * @param registry InterceptorRegistry to enable
     */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(metricServiceInterceptor);
	}

}