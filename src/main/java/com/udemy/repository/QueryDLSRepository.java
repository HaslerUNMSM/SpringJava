package com.udemy.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.entity.Categoria;
import com.udemy.entity.QCategoria;

@Repository("queryDSLRepository")
public class QueryDLSRepository {
	
	private QCategoria qCategoria = QCategoria.categoria;
	
	@PersistenceContext
	private EntityManager em;
	
	public Categoria find(boolean exist) {
		
		JPAQuery<Categoria> query = new JPAQuery<Categoria>(em);
		BooleanBuilder booleanBuilder = new BooleanBuilder(qCategoria.nombre.endsWith("OP"));

		if(exist) {
			Predicate predicate2 = qCategoria.id.eq(5);
			booleanBuilder.and(predicate2);
		}else {
			Predicate predicate3 = qCategoria.nombre.endsWith("OP");
			booleanBuilder.or(predicate3);
		}
			
		return query.select(qCategoria).from(qCategoria).where(qCategoria.id.eq(5)).fetchOne();
		
	}
			
}
