package com.txt.eshopperboot.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.txt.eshopperboot.dto.User;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName", "First name field is required.");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "lastName", "Last name field is required.");
        ValidationUtils.rejectIfEmpty(errors, "phone", "phone", "Phone is required.");
//		ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName", "First name field is required.");
//		ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName", "First name field is required.");
//		ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName", "First name field is required.");
//		ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName", "First name field is required.");
    }
}
