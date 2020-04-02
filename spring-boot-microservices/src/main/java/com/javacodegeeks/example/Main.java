package com.javacodegeeks.example;

import com.javacodegeeks.example.registration.EurekaServer;
import com.javacodegeeks.example.rest.addition.AdditionServer;
import com.javacodegeeks.example.rest.multiplication.MultiplicationServer;
import com.javacodegeeks.example.rest.subtraction.SubtractionServer;
import com.javacodegeeks.example.web.WebServer;
import com.javacodegeeks.example.zuul.ZuulGateway;


/**The Main file is for running specific servers/projects in the Microservice.
 * The following code allows user to run one server at a time, but user can run 
 * all servers at once through the command line. For commandline use:
 * " java -jar target/spring-boot-microservices-0.0.1-SNAPSHOT.jar serverName "
 * 
*
* @author  DeArvis Troutman
* @version 1.0
* @since   2020-04-02 
*/
public class Main
{
	public static void main(String[] args) 
	{

		String serverName = "";

		switch (args.length) 
		{
		case 2:
			System.setProperty("server.port", args[1]);
		case 1:
			serverName = args[0].toLowerCase();
			break;

		default:
			return;
		}

		if (serverName.equals("eureka")) 
		{
			EurekaServer.main(args);
		} 
		else if (serverName.equals("addition")) 
		{
			AdditionServer.main(args);
		} 
		else if (serverName.equals("subtraction"))
		{
			SubtractionServer.main(args);
		} 
		else if (serverName.equals("web")) 
		{
			WebServer.main(args);
		} 
		else if (serverName.equals("zuul")) 
		{
			ZuulGateway.main(args);
		}
		else if (serverName.equals("multiplication")) 
		{
			MultiplicationServer.main(args);
		}
		else 
		{
			System.out.println("Unknown server type: " + serverName);
		}
	}
}
