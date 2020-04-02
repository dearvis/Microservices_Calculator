package com.javacodegeeks.example.rest.multiplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* Home Controller
* The purpose of this class is to display the Html page for the multiplication server.
*
* @author  DeArvis Troutman
* @version 1.0
** @since   2020-04-02 
*/

@Controller
public class HomeController {

	/**
	 *  Displays index.html for the multiplication server
	 * @author DeArvis Troutman
	 */
	@RequestMapping("/")
	public String home() 
	{
		return "index";
	}

}