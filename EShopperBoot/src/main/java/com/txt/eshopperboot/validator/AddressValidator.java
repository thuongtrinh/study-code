package com.txt.eshopperboot.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.txt.eshopperboot.dto.Address;

public class AddressValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Address.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "city", "city", "City name is required.");
		ValidationUtils.rejectIfEmpty(errors, "country", "country", "Country name is required.");
		ValidationUtils.rejectIfEmpty(errors, "postalCode", "postalCode", "First name field is required.");
		ValidationUtils.rejectIfEmpty(errors, "addressOne", "addressOne", "Address one is required.");
	}


}
