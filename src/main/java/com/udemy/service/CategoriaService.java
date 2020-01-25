package com.udemy.service;

import java.util.List;

import com.udemy.entity.Categoria;

public interface CategoriaService {
	
	public abstract List<Categoria> ListaCategoria();
	public abstract Categoria addCategoria(Categoria categoria);
	public abstract int removeCategoria(int id);
	public abstract Categoria updateCategoria(Categoria categoria);
	
}
