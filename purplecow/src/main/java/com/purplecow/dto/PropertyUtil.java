package com.purplecow.dto;


import org.springframework.context.ApplicationContext;

import com.purplecow.service.ApplicationContextServe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropertyUtil {
	
	public static String getProperty(String propertyName) {
	
		return getProperty(propertyName, null);
	}
	
	public static String getProperty(String propertyName, String defaultValue) {
	
		String value = defaultValue;
		ApplicationContext applicationContext = ApplicationContextServe.getApplicationContext();
		if(applicationContext.getEnvironment().getProperty(propertyName) == null) {
			System.out.println(propertyName + " properties was not loaded.");
		} else {
			value = applicationContext.getEnvironment().getProperty(propertyName).toString();
		}
		return value;
	}
}

