package com.su.springboot.app.metricgathering.models.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.su.springboot.app.metricgathering.models.entity.Metric;
import com.su.springboot.app.metricgathering.models.service.MetricService;

/**
 * This class is a component that provides a custom implementation on HTTP operations
 * 
 * From HandlerInterceptor this class implements two abstract methods in order to collect request time and method type:
 * 		preHandle
 * 		postHandle
 * These are used to intercept client requests and process them
 * 
 * Also, for catch the body size of responses this class implements ResponseBodyAdvice class
 * in order to use the beforeBodyWrite method (body object)
 * 
 * Service layer used to persist the metrics collected is:
 * 		{@link com.su.springboot.app.metricgathering.models.service.MetricService}
 * 
 * In this context useful methods are getRandomHexString and getResponseBodyByteArray
 * @author hector.romero
 */
@ControllerAdvice
@Component
public class MetricServiceInterceptor extends HandlerInterceptorAdapter implements ResponseBodyAdvice<Object> {
	
	private static Logger log = LoggerFactory.getLogger(MetricServiceInterceptor.class);
	
	@Autowired
	MetricService metricService;
	
	Metric metric;

    /**
     * This method is used to intercept the request before it’s handed over to the handler method
     * Besides, this add an identifier to the Response Header that represents the response
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @param handler is a Object
     * @return a boolean value. It should be 'true' to let Spring know that process the request
     */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		log.info(String.format("%s routed to %s", request.getMethod(), request.getRequestURI()));		
		Long startTime = System.currentTimeMillis();

		String responseIdentifier = getRandomHexString(10);
		metric = new Metric();
		metric.setId(responseIdentifier);
		metric.setStartTime(startTime);

        response.addHeader("Response-Identifier", responseIdentifier);
		return true;
	}

    /**
     * This method is used to perform operations before sending the response to the client
     * Besides, it calculates the time request and set it to the Metric object and filters the calls from /gathering path
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @param handler is a Object
     */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Long endTime = System.currentTimeMillis();
        Long finalTime = endTime - metric.getStartTime();

		if (!request.getDispatcherType().name().equals(DispatcherType.ERROR.toString()) &&
				!request.getServletPath().contains("/gathering")
				) {
	        metric.setMethodType(request.getMethod().toString());
	        metric.setEndTime(endTime);
	        metric.setRequestTime(finalTime);
			metricService.save(metric);
		}

	}

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

    /**
     * This method allows customizing the response
     * Besides, this method uses getResponseBodyByteArray to convert the body object in a byte array
     * @param body Body object
     * @param returnType MethodParameter object
     * @param selectedContentType MediaType object
     * @param selectedConverterType Class<? extends HttpMessageConverter<?>>
     * @param request ServerHttpRequest object
     * @param response ServerHttpResponse object
     * @return a Body object
     */
	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {

		byte[] bodyByteArr = getResponseBodyByteArray(body);
		metric.setBodySize(new Long(bodyByteArr.length));

		return body;
	}

    /**
     * Getting an random hexadecimal number
     * @param numchars number of characters
     * @return a String value
     */
    private String getRandomHexString(int numchars){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < numchars){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, numchars);
    }

    /**
     * Converting a body object in a byte array in order to get the body size
     * @param body Body object
     * @return body size in a byte array
     */
    private byte[] getResponseBodyByteArray(Object body) {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos;
			oos = new ObjectOutputStream(bos);
			oos.writeObject(body);
			oos.flush();
			
			return bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    }
	
}
