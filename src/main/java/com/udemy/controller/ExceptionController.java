package com.udemy.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	public static final String EXAMPLE_EXCEPTION = "error/500";
	
	@ExceptionHandler(Exception.class)
	public String ControllerException() {
		return EXAMPLE_EXCEPTION;
	}
	
}
