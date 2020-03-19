
package com.javacodegeeks.example.rest.multiplication;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiplicationController 
{

	protected Logger logger = Logger.getLogger(MultiplicationController.class.getName() );
	
	
	@RequestMapping("/multiply")
	public String doMultiply(@RequestParam(defaultValue="0") String val_one, 
			@RequestParam(defaultValue="0") String val_two)
	{
		int a = Integer.valueOf(val_one);
		int b = Integer.valueOf(val_two);
		int product = a * b;
		
		return "{\"val_one\":\"" + val_one + "\", \"val_two\":\"" + val_two + "\", \"Product\": \"" + product + "\"}";
	}
}
