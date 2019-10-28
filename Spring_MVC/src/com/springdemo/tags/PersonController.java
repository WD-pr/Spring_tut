package com.springdemo.tags;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Value("#{countries}")
	private LinkedHashMap<String, String> countriesMap;
	
	@Value("#{languages}")
	private LinkedHashMap<String, String> programmingLanguagesMap;
	
	@RequestMapping("/")
	public String showForm(Model theModel) {
		
		Person person = new Person();
		theModel.addAttribute("person", person);
		theModel.addAttribute("countriesMap", countriesMap);
		theModel.addAttribute("programmingLanguagesMap", programmingLanguagesMap);
		programmingLanguagesMap.keySet().forEach(System.out::println);
		
		return "person-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("person") Person thePerson) {
		
		System.out.println("Person: " + thePerson);
		
		return "person-confirmation";
	}
	
}
