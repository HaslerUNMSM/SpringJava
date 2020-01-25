package com.udemy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.entity.Categoria;
import com.udemy.repository.CategoriaJpaRepository;
import com.udemy.service.CategoriaService;

@Service("categoriaService")
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	@Qualifier("categoriaJpaRepository")
	
	private CategoriaJpaRepository categoriaJpaRepository;
	
	@Override
	public List<Categoria> ListaCategoria() {
		return categoriaJpaRepository.findAll();
	}

	@Override
	public Categoria addCategoria(Categoria categoria) {
		return categoriaJpaRepository.save(categoria);
	}

	@Override
	public int removeCategoria(int id) {
		categoriaJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Categoria updateCategoria(Categoria categoria) {
		return categoriaJpaRepository.save(categoria);
	}

}
