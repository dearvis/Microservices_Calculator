package com.javacodegeeks.example.rest.subtraction;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Subtraction Server
 * The purpose of this class is to provide functionality to the server. 
 * 
* @author  DeArvis Troutman
* @version 1.0
* @since   2020-04-02 
*/


@RestController
public class SubtractionController {
	protected Logger logger = Logger.getLogger(SubtractionController.class
			.getName());


	/**
	 * The doSubtract method handles requests made on /subtract. 
	 * It retrieves the parameters and subtracts them. It then returns a JSON string.
	 * @param minued
	 * @param subtrahend
	 * @return difference in the form of a json string
	 */
	@RequestMapping("/subtract")
	public String doSubtract(@RequestParam(defaultValue="0") String minuend,
			@RequestParam(defaultValue="0") String subtrahend) {

		int m = Integer.valueOf(minuend);
		int s = Integer.valueOf(subtrahend);
		int difference = m - s;

		return "{\"minuend\":\"" + minuend + "\", \"subtrahend\":\"" + subtrahend + "\", \"difference\": \"" + difference + "\"}";
	}
}
