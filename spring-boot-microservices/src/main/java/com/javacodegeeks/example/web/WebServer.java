package com.javacodegeeks.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author  DeArvis Troutman
 * @version 1.0
* @since   2020-04-02 
 */

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false)
public class WebServer 
   {

	public static final String ADDITION_SERVICE_URL = "http://addition-service";

	public static final String SUBTRACTION_SERVICE_URL = "http://subtraction-service";
	
	public static final String MULTIPLICATION_SERVICE_URL = "http://multiplication-service";

	public static void main(String[] args)
		{
			System.setProperty("spring.config.name", "web-server");
			SpringApplication.run(WebServer.class, args);
		}
	
		@LoadBalanced
		@Bean
		RestTemplate restTemplate()	// Creates a Bean for RestTemplate so only using one Instance
		{
			return new RestTemplate();
		}
	
		@Bean
		public WebAdditionService additionService() // Creates a Bean for WebAdditionService so only using one Instance
		{
			return new WebAdditionService(ADDITION_SERVICE_URL);
		}
		
		
		@Bean
		public WebArithmeticController additionController() // Creates a Bean for WebArithmeticController so only using one Instance
		{
			return new WebArithmeticController( additionService(), subtractionService(), multiplicationService() );
		}	
		
		
		@Bean
		public WebSubtractionService subtractionService()  // Creates a Bean for WebSubtractionService so only using one Instance
		{
			return new WebSubtractionService(SUBTRACTION_SERVICE_URL);
		}
	
		@Bean
		public WebMultiplicationService multiplicationService()  // Creates a Bean for WebMultiplicationService so only using one Instance
		{
			return new WebMultiplicationService(MULTIPLICATION_SERVICE_URL);
		}
	
		
		@Bean
		public HomeController homeController() 
		{
			return new HomeController();
		}
			
	
}