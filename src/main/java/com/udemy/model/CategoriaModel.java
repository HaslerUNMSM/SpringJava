package com.udemy.model;

public class CategoriaModel {

	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CategoriaModel(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public CategoriaModel() {}
}
