package com.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String form(){
		return "hello-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(){
		return "hello";
	}
	
	@RequestMapping("/processFormRequestOne")
	public String processFormRequest(HttpServletRequest request, Model model){
		
		String name = request.getParameter("name");
		String result = "Hello " + name.toUpperCase() + " !";
		
		model.addAttribute("message", result);
		
		return "hello";
	
	}
		
	
	@RequestMapping("/processFormRequestTwo")
	public String processFormRequest(@RequestParam("name") String name, Model model){
		
		String result = "Hey " + name.toUpperCase() + " !";
		
		model.addAttribute("message", result);
		
		return "hello";
	
	}
}
