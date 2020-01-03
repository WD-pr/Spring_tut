package com.springdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* Spring MVC provides support for Spring REST.
 * 
 * @RestController annotation is a extension of @Controller. 
 * Handles REST requests and responses.
 * 
 * Spring REST automatically converts Java POJOs to JSON, 
 * if the Jakcson project is included. */

@RestController
@RequestMapping("/test")
public class DemoRestController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}
}
