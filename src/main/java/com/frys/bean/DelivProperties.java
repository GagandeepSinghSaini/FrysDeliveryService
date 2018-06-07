package com.frys.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:deliv.properties")
public class DelivProperties {
	
	@Value("${delivery.api.key}")
	private String apiKey;
	@Value("${tracking.url}")
	private String delivUrl;
	
	public String getDelivUrl() {
		return delivUrl;
	}
	public String getApiKey() {
		return apiKey;
	}
	
	
}
