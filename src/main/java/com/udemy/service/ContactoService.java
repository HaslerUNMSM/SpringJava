package com.udemy.service;

import java.util.List;

import com.udemy.entity.Contacto;
import com.udemy.model.ContactoModel;

public interface ContactoService {
	
	public abstract ContactoModel addContact(ContactoModel contactoModel);
	public abstract List<ContactoModel> ListaContacto();
	public abstract Contacto findContactById(int id);
	public abstract void removeContact(int id);
	public abstract ContactoModel findContactByIdModel(int id);
}
