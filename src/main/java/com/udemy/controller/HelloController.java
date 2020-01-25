package com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;

@Controller
@RequestMapping("/saludo")
public class HelloController {
	
	@Autowired
	@Qualifier("exampleService")
	
	private ExampleService exampleService;
	
	public static final String HelloView = "index";
	
	@GetMapping("/hola")
	public String HelloWorld(Model model) {
		model.addAttribute("people",exampleService.getListPeople());
		return HelloView;
	}
	
	@GetMapping("/holaMAV")
	public ModelAndView HelloMAV () {
		ModelAndView mav = new ModelAndView(HelloView);
		mav.addObject("person", new Person("Jhonatan",21));
		return mav;
	}
		
}
	