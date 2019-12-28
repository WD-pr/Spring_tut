package com.jackson.json.demo;

import java.io.File;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {

			// Creating object mapper
			ObjectMapper mapper = new ObjectMapper();

			// Reading JSON file and mapping it to JAVA POJO using Jackson

			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);

			System.out.println(student);
			System.out.println(student.getAddress());
			System.out.println("Languages: " + Arrays.toString(student.getLanguages()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
