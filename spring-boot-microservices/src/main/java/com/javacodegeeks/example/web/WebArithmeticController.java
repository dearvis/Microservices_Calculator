package com.javacodegeeks.example.web;

import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author  DeArvis Troutman
 * @version 1.0
* @since   2020-04-02 
 */


@Controller
public class WebArithmeticController 
{
	//Global Variables
	
	@Autowired
	protected WebAdditionService additionService;

	@Autowired
	protected WebSubtractionService subtractionService;
	
	@Autowired
	protected WebMultiplicationService multiplicationService;

	protected Logger logger = Logger.getLogger(WebArithmeticController.class.getName());

	
	
	// Methods
	public WebArithmeticController(WebAdditionService additionService, WebSubtractionService subtractionService, WebMultiplicationService multiplicationService) 
	{
		this.additionService = additionService;
		this.subtractionService = subtractionService;
		this.multiplicationService = multiplicationService;
	}

	

	/**
	 * The purpose of this method is to make API Call to Addition Service
	 * @param addend1
	 * @param addend2
	 * @param model
	 * @return sum 
	 */
	@RequestMapping("/add")
	public String doAdd(@RequestParam(defaultValue="0") String addend1,	@RequestParam(defaultValue="0") String addend2,	Model model) 
	{
		String sum = additionService.add(addend1, addend2);
		logger.info("Sum: " + sum);
		model.addAttribute("json", sum);
		return "sum";
	}

	
	
	/**
	 * The purpose of this method is to make API Call to Subtraction Service
	 * @param minuend
	 * @param subtrahend
	 * @param model
	 * @return difference
	 */
	@RequestMapping("/subtract")
	public String doSubtract(@RequestParam(defaultValue="0") String minuend, @RequestParam(defaultValue="0") String subtrahend,	Model model) 
	{
		String difference = subtractionService.subtract(minuend, subtrahend);
		logger.info("Difference: " + difference);
		model.addAttribute("json", difference);
		return "difference";
	}
	
	
	/**
	 * The purpose of this method is to make API Call to Multiplication Service
	 * @param val_one
	 * @param val_two
	 * @param model
	 * @return product
	 */
	@RequestMapping("/multiplication")
	public String doMultiply(@RequestParam(defaultValue="0") String val_one, @RequestParam(defaultValue="0") String val_two, Model model) 
	{
		String product = multiplicationService.multiply(val_one, val_two);
		logger.info("Product: " + product);
		model.addAttribute("json", product);
		return "product";
	}
	
}
