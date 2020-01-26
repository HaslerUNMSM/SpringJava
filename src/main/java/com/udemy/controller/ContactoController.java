package com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.webkit.ContextMenu.ShowContext;
import com.udemy.constant.ViewConstant;
import com.udemy.model.ContactoModel;
import com.udemy.service.ContactoService;

@Controller
@RequestMapping("/contacts")
public class ContactoController {

	@Autowired
	@Qualifier("contactoService")

	private ContactoService contactoService;

	@GetMapping("/cancel")
	public String cancel(Model model) {
		return "redirect:/contacts/showcontacts";
	}
	
	@GetMapping("/contactform")
	public String contactForm(Model model) {
		model.addAttribute("contacto", new ContactoModel());
		return ViewConstant.CONTACT_FORM;
	}
	
	@GetMapping("/showcontacts")
	public ModelAndView showContacts() {
		 ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
		 mav.addObject("contactos", contactoService.ListaContacto());
		 return mav;
	}
	
	@GetMapping("/removecontact")
	public ModelAndView removeContacts(@RequestParam(name="id", required = true) int id) {
		contactoService.removeContact(id);	
		return showContacts();
	}

	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute("contacto") ContactoModel contactoModel, Model model) {
		if(contactoService.addContact(contactoModel) != null) {
			model.addAttribute("resultado", 1);
		}else
			model.addAttribute("resultado", 0);	
		
		return "redirect:/contacts/showcontacts"	;
	}
}
