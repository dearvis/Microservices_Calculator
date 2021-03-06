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
public class WebMultiplicationService 
{
	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	protected Logger logger = Logger.getLogger(WebMultiplicationService.class
			.getName());
	
	public WebMultiplicationService(String serviceUrl)
	{
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	
	/**
	 * Returns URL after Multiplication operation (REST API Call)
	 * @param val_one
	 * @param val_two
	 * @return returns object 
	 */
	public String multiply(String val_one, String val_two)
	{
		return restTemplate.getForObject(serviceUrl + "/multiply?val_one={val_one}&val_two={val_two}", String.class, val_one, val_two);
	}
	
}
