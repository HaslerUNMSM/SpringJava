package com.udemy.converter;

import org.springframework.stereotype.Component;

import com.udemy.entity.Contacto;
import com.udemy.model.ContactoModel;

@Component("contactoConverter")
public class ContactoConverter {

	// entity --> model
	public ContactoModel entity2model(Contacto contacto) {
		ContactoModel contactoModel = new ContactoModel();
		contactoModel.setFirstname(contacto.getFirstname());
		contactoModel.setLastname(contacto.getLastname());
		contactoModel.setTelephone(contacto.getTelephone());
		contactoModel.setCity(contacto.getCity());
		return contactoModel;
	}

	// model --> entity
	public Contacto model2entity(ContactoModel contactoModel) {
		Contacto contacto  = new Contacto();
		contacto.setFirstname(contactoModel.getFirstname());
		contacto.setLastname(contactoModel.getLastname());
		contacto.setTelephone(contactoModel.getTelephone());
		contacto.setCity(contactoModel.getCity());
		return contacto;
	}
}
