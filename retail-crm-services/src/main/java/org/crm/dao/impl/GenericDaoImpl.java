package org.crm.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.crm.dao.model.GenericDao;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {
	
	@PersistenceContext
	protected EntityManager em;
	
	private Class<T> type;

	public T persist(T obj) {
		em.persist(obj);
		return obj;
	}

	public void remove(Object obj) {
		em.remove(em.getReference(type, obj));
	}

	public T find(Object id) {
		return em.find(type, id);
	}
	

}
