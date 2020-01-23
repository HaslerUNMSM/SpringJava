package com.udemy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.model.Person;

@Controller
@RequestMapping("/saludo")
public class HelloController {
	
	public static final String HelloView = "index";
	
	@GetMapping("/hola")
	public String HelloWorld(Model model) {
		model.addAttribute("people",getPeople());
		return HelloView;
	}
	
	@GetMapping("/holaMAV")
	public ModelAndView HelloMAV () {
		ModelAndView mav = new ModelAndView(HelloView);
		mav.addObject("person", new Person("Jhonatan",21));
		return mav;
	}
	
	private List<Person> getPeople(){
		List<Person> people = new ArrayList<>();
		people.add(new Person("Hasler",21));
		people.add(new Person("Jhonata",20));
		people.add(new Person("Licapa",19));
		people.add(new Person("Infanzon",18));
		return people;
	}
	
}
	