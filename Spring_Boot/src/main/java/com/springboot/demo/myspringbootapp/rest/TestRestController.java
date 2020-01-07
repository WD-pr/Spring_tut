package com.springboot.demo.myspringbootapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World ! " + LocalDateTime.now();
	}
	
	@GetMapping("/team")
	public String showTeam() {
		return "The team is: " + teamName + ", and their coach: " + coachName;
	}
}
