package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.component.RequestTimeInterceptor;
import com.udemy.model.Person;

@Controller
@RequestMapping("/example2")
public class Hello3Controller {
	
	public static final String EXAMPLE_VIEW = "index";
	public static final String EXAMPLE_RESULT = "resultado";
	private static final Log LOGGER = LogFactory.getLog(Hello3Controller.class);

	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	@GetMapping("/formulario")
	public String VerFormulario(Model model) {
		exampleComponent.sayHello();
		/*LOGGER.info("INFO TRACE");
		LOGGER.warn("WARNING TRACE");
		LOGGER.error("ERROR TRACE");
		LOGGER.debug("DEBUG TRACE");*/
		model.addAttribute("person", new Person());
		return EXAMPLE_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView HelloController(@ModelAttribute ("person") Person person) {
		LOGGER.info("METHOD: 'addPerson' -- PARAMS: '" + person + "'");
		ModelAndView mav = new ModelAndView(EXAMPLE_RESULT);
		mav.addObject("person", person);
		LOGGER.info("TEMPLATE: '" + EXAMPLE_RESULT + "' -- DATA: '" + person + "'");
		return mav;
	}
}
