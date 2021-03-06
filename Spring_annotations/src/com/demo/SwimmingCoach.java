package com.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
	Using default bean id - swimmingCoach - instead of specified one: @Component("myCoach"). 
	Note: When the first and second characters of the class name are upper case, then the 
	name is NOT converted, i.e. URLSth --> URLSth.
*/
@Component
@Scope("prototype")
public class SwimmingCoach implements Coach {

	/*
	 * Field Injection applied directly to the field without setter method. Can be
	 * applied to private field also.
	 */
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// Using properties file to set values

	@Value("${email}")
	private String email;

	@Value("${team}")
	private String team;
	
	/*
	 * //Constructor Injection:
	 * 
	 * @Autowired public SwimmingCoach(@Qualifier("randomFortuneService")
	 * FortuneService fortuneService) { this.fortuneService = fortuneService; }
	 */

	/*
	 * Method Injection can be executed through setter method or any other method
	 * like:
	 * 
	 * @Autowired doSomething(FortuneService fortuneService)
	 */
	/*
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */

	@Override
	public String getDailyWorkout() {
		return "Practice backstroke swimming";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	/*
	 * BEAN LIFECYCLE METHODS
	 * 
	 * @PostContruct and @PreDestroy 
	 * - can have any access modifier
	 * - any return type, void is mostly used as any other return type is not captured
	 * - any method name
	 * - cannot accept any arguments
	 */
	
	@PostConstruct
	public void init() {
		System.out.println("Swimming Coach - initialization");
	}
	
	// No action when SCOPE = prototype
	@PreDestroy
	public void des() {
		System.out.println("Swimming Coach - destroy");
	}
	
	@Override
	public String toString() {
		return "SwimmingCoach [email=" + email + ", team=" + team + "]";
	}

}
