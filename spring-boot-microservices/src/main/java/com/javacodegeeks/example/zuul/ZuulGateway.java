package com.javacodegeeks.example.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
* @author  DeArvis Troutman
* @version 1.0
* @since   2020-04-02 
*/

@SpringBootApplication
@EnableEurekaClient  // Enables Discovery by Eureka Server
@EnableZuulProxy	 // Acts as Zuul Gateway

public class ZuulGateway 
{

	public static void main(String[] args)
	{
		System.setProperty("spring.config.name", "zuul-server");
		SpringApplication.run(ZuulGateway.class, args);
	}
	
}
