package com.txt.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultException {

	@ExceptionHandler(NoHandlerFoundException.class)
	public String HandlerException(Model model) {
		model.addAttribute("errorTitle", "The page is not constructed!");
		model.addAttribute("errorDescription", "The page you are looking for is not available now!");
		return "error";
	}

	@ExceptionHandler(Exception.class)
	public String HandlerException(Exception e, Model model) {
		model.addAttribute("errorTitle", "Contact Your Administrator!");
		model.addAttribute("errorDescription", e.toString());
		return "error";
	}

}

