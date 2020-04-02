package com.javacodegeeks.example.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
* The purpose of this class is to configure the Eureka Server. 
* The Eureka ServerCollects the name, IP address and number of instances
* of all application services. 
*
* @author  DeArvis Troutman
* @version 1.0
* @since   2020-04-02 
*/


@SpringBootApplication // Triggers auto configuration (background process for spring application) and component scanning
@EnableEurekaServer    // AutoConfigures Eureka Discovery Server
public class EurekaServer 
{
	public static void main(String[] args)
	{
		System.setProperty("spring.config.name", "eureka-server");

		SpringApplication.run(EurekaServer.class, args);
	}
}
