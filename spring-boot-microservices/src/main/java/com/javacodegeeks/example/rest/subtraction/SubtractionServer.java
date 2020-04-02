package com.javacodegeeks.example.rest.subtraction;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
* The purpose of this class is to configure the server for the Subtraction Service Application
* 
* @author  DeArvis Troutman
* @version 1.0
* @since   2020-04-02 
*/

@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan
public class SubtractionServer 
{
	protected Logger logger = Logger.getLogger(SubtractionServer.class.getName());

	public static void main(String[] args)
	{
		System.setProperty("spring.config.name", "subtraction-server");

		SpringApplication.run(SubtractionServer.class, args);
	}
}
