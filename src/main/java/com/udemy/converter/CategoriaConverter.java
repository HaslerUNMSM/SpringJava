package com.udemy.converter;

import org.springframework.stereotype.Component;

import com.udemy.entity.Categoria;
import com.udemy.model.CategoriaModel;

@Component("categoriaConverter")
public class CategoriaConverter {

	//entity --> model
	public CategoriaModel entity2model (Categoria categoria) {
		CategoriaModel categoriaModel = new CategoriaModel();
		categoriaModel.setNombre(categoria.getNombre());
		return categoriaModel;
	}
	
	//model --> entity
	public Categoria model2entity (CategoriaModel categoriaModel) {
		Categoria categoria = new Categoria();
		categoria.setNombre(categoriaModel.getNombre());
		return categoria;
	}
}
