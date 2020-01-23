package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class Hello2Controller {
	
	public static final String EXAMPLE_VIEW = "index";
	
	//localhost:8080/example/request?nm=HASLER	
	@GetMapping("/request")
	public ModelAndView HelloMAV2(@RequestParam(name="nm", required = false, defaultValue = "NULL" ) String name) {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("nm_in_model", name);	
		return mav;
	}
	
	@GetMapping("/request2/{nm}")
	public ModelAndView HelloMAV3(@PathVariable("nm") String name) {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("nm_in_model", name);
		return mav;
	}
}
