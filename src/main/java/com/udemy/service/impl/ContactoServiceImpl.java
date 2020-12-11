package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.converter.ContactoConverter;
import com.udemy.entity.Contacto;
import com.udemy.model.ContactoModel;
import com.udemy.repository.ContactoRepository;
import com.udemy.service.ContactoService;

@Service("contactoService")
public class ContactoServiceImpl implements ContactoService{

	@Autowired
	@Qualifier("contactoRepository")
	
	private ContactoRepository contactoRepository;
	
	@Autowired
	@Qualifier("contactoConverter")
	
	private ContactoConverter contactoConverter;
	
	@Override
	public ContactoModel addContact(ContactoModel contactoModel) {
		Contacto contacto = contactoRepository.save(contactoConverter.model2entity(contactoModel));
		return contactoConverter.entity2model(contacto);
	}

	@Override
	public List<ContactoModel> ListaContacto() {
		List<Contacto> contactos = contactoRepository.findAll();
		List<ContactoModel> contactosModels = new ArrayList<ContactoModel>();
		for (Contacto contacto: contactos) {
			contactosModels.add(contactoConverter.entity2model(contacto));
		}
		return contactosModels;
	}

	@Override
	public Contacto findContactById(int id) {
		return contactoRepository.findById(id);
	}

	@Override
	public void removeContact(int id) {
		Contacto contacto = findContactById(id);
		if(null != contacto) {
			contactoRepository.delete(contacto);
		}
	}

	@Override
	public ContactoModel findContactByIdModel(int id) {
		Contacto contacto = findContactById(id);
		ContactoModel contactoModel = contactoConverter.entity2model(contacto);
		return contactoModel;
	}
}
