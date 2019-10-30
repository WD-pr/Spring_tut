package com.springdemo.tags;

import java.util.LinkedHashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Value("#{countries}")
	private LinkedHashMap<String, String> countriesMap;

	@Value("#{languages}")
	private LinkedHashMap<String, String> programmingLanguagesMap;

	/*
	 * Pre-processing all incoming form requests to convert input strings: -
	 * trimming whitespace - converting string to null in case of all whitespace
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
	}
	
	@RequestMapping("/")
	public String showForm(Model theModel) {

		Person person = new Person();
		theModel.addAttribute("person", person);
		theModel.addAttribute("countriesMap", countriesMap);
		theModel.addAttribute("programmingLanguagesMap", programmingLanguagesMap);

		return "person-form";
	}

	@RequestMapping("/processForm")
	public String processForm(Model theModel, @Valid @ModelAttribute("person") Person thePerson, BindingResult theBindingResult) {

		System.out.println("Person: " + thePerson);
		theModel.addAttribute("countriesMap", countriesMap);
		theModel.addAttribute("programmingLanguagesMap", programmingLanguagesMap);
		
		if(theBindingResult.hasErrors()) {
			return "person-form";
		}
		
		return "person-confirmation";
	}
	
	

}
