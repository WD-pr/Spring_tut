package com.springboot.demo.myspringbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* @SpringBootApplication annotation enables:
	- Spring Boots's auto configuration support (@EnableAutoConfiguration)
	- Component scanning of the current package and sub-packages recursively (@ComponentScan)
	- Additional configuration - extra beans @Bean and import other configuration classes (@Configuration)
*/

@SpringBootApplication
public class MyspringbootappApplication {

	public static void main(String[] args) {
		/*
		 * SpringApplication bootstrap app - creates application context, registers all
		 * beans and start embedded server
		 */
		SpringApplication.run(MyspringbootappApplication.class, args);
	}

}
