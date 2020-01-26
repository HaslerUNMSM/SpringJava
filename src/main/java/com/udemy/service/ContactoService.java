package com.udemy.service;

import java.util.List;

import com.udemy.model.ContactoModel;

public interface ContactoService {
	
	public abstract ContactoModel addContact(ContactoModel contactoModel);
	public abstract List<ContactoModel> ListaContacto();
}
