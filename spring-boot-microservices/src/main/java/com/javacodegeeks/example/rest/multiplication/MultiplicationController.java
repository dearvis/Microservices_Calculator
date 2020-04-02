
package com.javacodegeeks.example.rest.multiplication;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Multiplication Server
 ** The purpose of this class is to provide functionality to the server. 
 * 
* @author  DeArvis Troutman
* @version 1.0
* @since   2020-04-02 
*/

@RestController
public class MultiplicationController 
{

	protected Logger logger = Logger.getLogger(MultiplicationController.class.getName() );
	
	
	/**
	 *  The doMultiply method handles requests made on /multiply. 
	 * It retrieves the parameters and multiplies them. It then returns a JSON string.
	 *  
	 * @param val_one
	 * @param val_two
	 * @return Returns product in the form of json. 
	 */
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
