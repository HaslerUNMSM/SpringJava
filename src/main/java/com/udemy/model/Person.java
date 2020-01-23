package com.udemy.model;

public class Person {

	private String nombre;
	private int edad;
	
	public Person() {}

	public Person(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Person [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
}
