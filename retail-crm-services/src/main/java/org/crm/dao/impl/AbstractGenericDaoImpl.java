package org.crm.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import org.crm.dao.model.AbstractGenericDao;

@Transactional
public class AbstractGenericDaoImpl<PK extends Serializable, T extends Serializable>
		implements AbstractGenericDao<PK, T> {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	protected EntityManager em;

	private Class<?> type;

	protected AbstractGenericDaoImpl(Class<?> type) {
		this.type = type;
	}
    /**
     * {@inheritDoc}
     */
    public T saveOrUpdate(T entity) {
		this.validate(entity);
		return em.merge(entity);
	}

    /**
     * {@inheritDoc}
     */
	public T persist(T entity) {
		this.validate(entity);
		em.persist(entity);
		return entity;
	}

    /**
     * {@inheritDoc}
     */
    public void remove(PK primaryKey) {
		em.remove(em.getReference(type, primaryKey));
	}

    /**
     * {@inheritDoc}
     */
    public T find(PK primaryKey) {
		return (T) em.find(type, primaryKey);
	}

    /**
     * {@inheritDoc}
     */
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
