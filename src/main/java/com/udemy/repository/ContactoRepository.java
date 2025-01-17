package com.udemy.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.entity.Contacto;

@Repository("contactoRepository")
public interface ContactoRepository extends JpaRepository<Contacto, Serializable>{
	
	public abstract Contacto findById(int id);
}
