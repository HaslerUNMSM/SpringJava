package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.constant.ViewConstant;
import com.udemy.model.CredencialModel;

@Controller
public class LoginController {

	@GetMapping("/")
	public String redirectToLogin() {
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model,@RequestParam(name="error", required = false) String error,
			@RequestParam(name="logout", required = false) String logout) {
		model.addAttribute("error",error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredencial", new CredencialModel());
		return ViewConstant.LOGIN;
	}
	
	@PostMapping("/logincheck")
	public String LoginCheck(@ModelAttribute("userCredencial") CredencialModel credencialModel) {
		if(credencialModel.getUsername().equals("user") && credencialModel.getPassword().equals("user")){
			return "redirect:/contacts/showcontacts";
		}else
			return "redirect:/login?error";	
	}
}
