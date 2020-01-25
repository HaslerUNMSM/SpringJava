package com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.converter.CategoriaConverter;
import com.udemy.entity.Categoria;
import com.udemy.service.CategoriaService;

@Controller
@RequestMapping("categorias")
public class CategoriaController {

	public static final String CATEGORIA = "categoria";
	
	@Autowired
	@Qualifier("categoriaService")
	
	private CategoriaService categoriaService;
	
	/*@Autowired
	@Qualifier("categoriaConverter")
	
	private CategoriaConverter categoriaConverter;*/
	
	@GetMapping("/listacategorias")
	public ModelAndView MavCategoria() {
		 ModelAndView mav = new ModelAndView(CATEGORIA);
		 mav.addObject("categoria", new Categoria());
		 mav.addObject("categorias", categoriaService.ListaCategoria());
		 return mav;
	}
	
	@PostMapping("/addcategoria")
	public String addCategoria(@ModelAttribute("categoria") Categoria categoria) {
		categoriaService.addCategoria(categoria);
		return "redirect:/categorias/listacategorias";
	}
}
