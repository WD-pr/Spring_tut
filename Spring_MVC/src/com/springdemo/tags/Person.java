package com.springdemo.tags;

import java.util.Arrays;
import java.util.LinkedHashMap;


public class Person {

	private String firstName;
	private String lastName;
	private String country;
	private String programmingLanguage;
	private String[] operatingSystems;
	
	
	private LinkedHashMap<String, String> countriesList;
	private LinkedHashMap<String, String> operatingSystemsList;

	
	public Person() {

		countriesList = new LinkedHashMap<String, String>();
		countriesList.put("DE", "Germany");
		countriesList.put("PL", "Poland");
		countriesList.put("AT", "Austria");
		countriesList.put("ES", "Spain");
		
		operatingSystemsList = new LinkedHashMap<String, String>();
		operatingSystemsList.put("Mac", "Mac OS");
		operatingSystemsList.put("Win", "MS Windows");
		operatingSystemsList.put("Linux", "Linux");
		
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getProgrammingLanguage() {
		return programmingLanguage;
	}
	
	public String[] getOperatingSystems() {
		return operatingSystems;
	}
	
	public LinkedHashMap<String, String> getCountriesList() {
		return countriesList;
	}
	
	public LinkedHashMap<String, String> getOperatingSystemsList() {
		return operatingSystemsList;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", country=" + country
				+ ", programmingLanguage=" + programmingLanguage + ", operatingSystems="
				+ Arrays.toString(operatingSystems) + "]";
	}

	
	

	
}
