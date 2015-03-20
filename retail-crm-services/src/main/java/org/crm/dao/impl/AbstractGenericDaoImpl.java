package org.crm.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import org.crm.dao.model.AbstractGenericDao;
import org.springframework.test.context.transaction.TransactionConfiguration;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class AbstractGenericDaoImpl<PK extends Serializable, T extends Serializable>
		implements AbstractGenericDao<PK, T> {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	protected EntityManager em;

	private Class<?> type;

	protected AbstractGenericDaoImpl(Class<?> type) {
		this.type = type;
	}

	public T saveOrUpdate(T entity) {
		this.validate(entity);
		T e = em.merge(entity);
		return e;
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
		return (T) em.find(type, primaryKey);
	}

	public void refresh(T entity) {
		em.refresh(entity);
	}

	/**
	 * 
	 * @param entity
	 */
	protected void validate(final T entity) {
		if (entity == null) {
			throw new IllegalArgumentException("Entity is null");
		}
	}

}
