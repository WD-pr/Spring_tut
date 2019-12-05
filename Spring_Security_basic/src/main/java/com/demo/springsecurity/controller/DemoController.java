package com.demo.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showLanding() {
		return "landing";
	}
	
	@GetMapping("/home")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/leaders")
	public String showLeadersPage() {
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String showAdminPage() {
		return "systems";
	}
}
