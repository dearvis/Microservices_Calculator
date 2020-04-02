package com.javacodegeeks.example.rest.addition;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
* Addition Controller
* The purpose of this class is to provide functionality to the server. 
*
* @author  DeArvis Troutman
* @version 1.0
* @since   2020-04-02 
*/

@RestController  
public class AdditionController {

	protected Logger logger = Logger.getLogger(AdditionController.class
			.getName());


	/**
	 * The doAdd method handles requests made on /add. 
	 * It retrieves the parameters and adds them. It then returns a JSON string.
	 * @param addend1
	 * @param addend2
	 * @return sum in the form of a json string
	 */
	@RequestMapping("/add")
	public String doAdd(@RequestParam(defaultValue="0") String addend1,
			@RequestParam(defaultValue="0") String addend2) {

		int augend1 = Integer.valueOf(addend1);
		int augend2 = Integer.valueOf(addend2);
		int sum = augend1 + augend2;

		return "{\"addend1\":\"" + addend1 + "\", \"addend2\":\"" + addend2 + "\", \"sum\": \"" + sum + "\"}";
	}
}
