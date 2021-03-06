package com.javacodegeeks.example.web;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
* @author  DeArvis Troutman
* @version 1.0
* @since   2020-04-02 
*/


@Service
public class WebSubtractionService {
	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	protected Logger logger = Logger.getLogger(WebSubtractionService.class
			.getName());

	public WebSubtractionService(String serviceUrl)
	{
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}


	/**
	 * Returns URL after addition operation has been applied
	 * @param minuend
	 * @param subtrahend
	 * @return returns object (REST API Call)
	 */
	public String subtract(String minuend, String subtrahend) {
		return restTemplate.getForObject(serviceUrl + "/subtract?minuend={minuend}&subtrahend={subtrahend}", String.class, minuend, subtrahend);
	}
//	int m = Integer.valueOf(minuend);
//	int s = Integer.valueOf(subtrahend);
//	int difference = m - s;
}
