package com.javacodegeeks.example.zuul;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
* Home Controller
* The purpose of this class is to display the HTML page for the Addition server.
*
* @author  DeArvis Troutman
* @version 1.0
** @since   2020-04-02 
*/


@Controller
public class HomeController 
{

	/**
	 *  Displays index.html for Zuul Gateway
	 * @author DeArvis Troutman
	 */
	@RequestMapping("/")
	public String home() 
	{
		return "index";
	}

}