package com.springdemo.tags;

import java.util.Arrays;
import java.util.LinkedHashMap;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.springdemo.validation.Height;


public class Person {

	
	private String firstName;
	
	@NotNull(message = "is required")
	@Size(min=2, message="is required")
	private String lastName;
	
	private String country;
	private String programmingLanguage;
	
	/* In case of int field use @Min, @Max */
	@Size(min = 1, message="choose minimum 1 OS")
	@Size(max = 2, message="choose maximum 2 OS")
	private String[] operatingSystems;
	
	@Pattern(regexp="\\d{2}-\\d{3}", message = "input text in format: 00-000")
	private String postalCode;
	
	@Height
	@NotNull(message = "is required") // - working on Object types, not primitive types
	private Integer height;
	
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
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public Integer getHeight() {
		return height;
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

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public void setHeight(Integer height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", country=" + country
				+ ", programmingLanguage=" + programmingLanguage + ", operatingSystems="
				+ Arrays.toString(operatingSystems) + "]";
	}

	
	

	
}
