package com.txt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.txt.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {
		Product product = (Product) target;
		
		
		
		
		
		
	}

}
