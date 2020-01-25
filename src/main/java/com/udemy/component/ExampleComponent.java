package com.udemy.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.udemy.repository.CategoriaJpaRepository;

@Component("exampleComponent")
public class ExampleComponent {

	private static final Log LOG = LogFactory.getLog(ExampleComponent.class);
	
	@Autowired
	@Qualifier("categoriaJpaRepository")
	private CategoriaJpaRepository categoriaJpaRepository;
	
	public void sayHello() {
		//categoriaJpaRepository.findById(1);
		LOG.info("HELLO EXAMPLE COMPONENT");
	}
}
