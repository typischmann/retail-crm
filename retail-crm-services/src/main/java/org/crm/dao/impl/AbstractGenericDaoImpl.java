package org.crm.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.crm.dao.model.AbstractGenericDao;

@Transactional
public abstract class AbstractGenericDaoImpl<PK extends Serializable, T extends Serializable> implements AbstractGenericDao<PK, T> {
	
	@PersistenceContext
	protected EntityManager em;
	
	private Class<T> type;
	
	public T update(T entity){
		this.validate(entity);
		return em.merge(entity);
	}

	public T persist(T entity) {
		this.validate(entity);
		em.persist(entity);
		return entity;
	}

	public void remove(PK primaryKey) {
		em.remove(em.getReference(type, primaryKey));
	}

	public T find(PK primaryKey) {
		return em.find(type, primaryKey);
	}
	
	public void refresh(T entity){
		em.refresh(entity);
	}
	
	/**
	 * 
	 * @param entity
	 */
	protected void validate(final T entity){
		if(entity==null){
			throw new IllegalArgumentException("Entity is null");
		}
	}
	

}
