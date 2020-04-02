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
public class WebAdditionService 
{
	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	protected Logger logger = Logger.getLogger(WebAdditionService.class.getName());

	public WebAdditionService(String serviceUrl) 
	{
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
	}


	/**
	 * Returns URL after addition operation has been applied
	 * @param addend1
	 * @param addend2
	 * @return returns object (REST API Call)
	 */
	public String add(String addend1, String addend2) 
	{
		return restTemplate.getForObject(serviceUrl + "/add?addend1={addend1}&addend2={addend2}", String.class, addend1, addend2);
	}
	
}
