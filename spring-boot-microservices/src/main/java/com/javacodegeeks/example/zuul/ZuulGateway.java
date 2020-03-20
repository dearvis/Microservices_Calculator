package com.javacodegeeks.example.zuul;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.javacodegeeks.example.web.HomeController;
import com.javacodegeeks.example.web.WebAdditionService;
import com.javacodegeeks.example.web.WebArithmeticController;
import com.javacodegeeks.example.web.WebMultiplicationService;
import com.javacodegeeks.example.web.WebSubtractionService;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZuulGateway 
{

	public static final String ADDITION_SERVICE_URL = "http://addition-service";

	public static final String SUBTRACTION_SERVICE_URL = "http://subtraction-service";
	
	public static final String MULTIPLICATION_SERVICE_URL = "http://multiplication-service";

	public static void main(String[] args)
	{
		System.setProperty("spring.config.name", "zuul-server");
		SpringApplication.run(ZuulGateway.class, args);
	}
	
	
		@LoadBalanced
		@Bean
		RestTemplate restTemplate()
		{
			return new RestTemplate();
		}
	
		@Bean
		public WebAdditionService additionService()
		{
			return new WebAdditionService(ADDITION_SERVICE_URL);
		}
		
		
		@Bean
		public WebArithmeticController additionController() 
		{
			return new WebArithmeticController( additionService(), subtractionService(), multiplicationService() );
		}	
		
		
		@Bean
		public WebSubtractionService subtractionService() 
		{
			return new WebSubtractionService(SUBTRACTION_SERVICE_URL);
		}
	
		@Bean
		public WebMultiplicationService multiplicationService() 
		{
			return new WebMultiplicationService(MULTIPLICATION_SERVICE_URL);
		}
	
		
		@Bean
		public HomeController homeController() 
		{
			return new HomeController();
		}

}
