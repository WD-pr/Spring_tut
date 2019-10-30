package com.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HeightConstraintValidator implements ConstraintValidator<Height, Integer>{

	private int min;
	private int max;
	
	
	@Override
	public void initialize(Height theHeight) {
		min = theHeight.min();
		max = theHeight.max();
	}

	@Override
	public boolean isValid(Integer height, ConstraintValidatorContext constraintValidatorContext) {

		if(height == null) {
			return true;
		}
		
		boolean result = height.intValue() >= min && height.intValue() <= max;
		
		return result;
	}
	

}
