package com.su.springboot.app.metricgathering.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.su.springboot.app.metricgathering.models.entity.Metric;
import com.su.springboot.app.metricgathering.models.repository.MetricRepository;
import com.su.springboot.app.metricgathering.models.service.impl.MetricServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class MetricServiceTest {

	@InjectMocks
	MetricServiceImpl metricService;
	
	@Mock
	MetricRepository metricRepository;
    
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllMetricsTest() {
		
		List<Metric> metrics = new ArrayList<>();
		Metric metricOne = new Metric();
		metricOne.setId("bbf5c66056");
		metricOne.setBodySize(1212L);
		metricOne.setStartTime(1600984932069L);
		metricOne.setEndTime(1600984932112L);
		metricOne.setRequestTime(43L);
		metricOne.setMethodType("GET");

		Metric metricTwo = new Metric();
		metricTwo.setId("wsf554e056");
		metricTwo.setBodySize(1212L);
		metricTwo.setStartTime(1600984932703L);
		metricTwo.setEndTime(1600984932709L);
		metricTwo.setRequestTime(6L);
		metricTwo.setMethodType("GET");
		
		Metric metricThree = new Metric();
		metricThree.setId("qgf5c69876");
		metricThree.setBodySize(1090L);
		metricThree.setStartTime(1600984930000L);
		metricThree.setEndTime(1600984937611L);
		metricThree.setRequestTime(55L);
		metricThree.setMethodType("POST");
		
		metrics.add(metricOne);
		metrics.add(metricTwo);
		metrics.add(metricThree);
		
		when(metricRepository.findAll()).thenReturn(metrics);
		
		List<Metric> metricList = metricService.findAll();
		
		assertEquals(3, metricList.size());
		verify(metricRepository, times(1)).findAll();
	}
	
	@Test
	public void saveMetricTest() {
		
		Metric metricToPersist = new Metric();
		metricToPersist.setId("abf5a12352");
		metricToPersist.setBodySize(1242L);
		metricToPersist.setStartTime(1600984932069L);
		metricToPersist.setEndTime(1600984932112L);
		metricToPersist.setRequestTime(42L);
		metricToPersist.setMethodType("GET");
		
		when(metricRepository.save(metricToPersist)).thenReturn(metricToPersist);
		
		Metric metricObj = metricService.save(metricToPersist);
		
		assertEquals("GET", metricObj.getMethodType());
		verify(metricRepository, times(1)).save(metricToPersist);
	}
	
}
