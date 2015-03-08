package org.crm.dao.model;

import java.io.Serializable;

public interface AbstractGenericDao<PK extends Serializable, T extends Serializable> {
	
	/**
	 * 
	 * @param entity object which is saving or updating into the schema.
	 * @return the saved or updated entity reference.
	 */
	public T saveOrUpdate(T entity);
	
	/**
	 * 
	 * @param entity object which is persisting into the schema.
	 * @return the persisted entity reference.
	 */
	public T persist(T entity);
	
	/**
	 * 
	 * @param primaryKey the primary key of the generic schema.
	 */
	public void remove(PK primaryKey);
	
	/**
	 * 
	 * @param primaryKey the primary of the generic schema.
	 * @return the entity which associated with the primary key, or null if not found.
	 */
	public T find(PK primaryKey);
	
	/**
	 * 
	 * @param entity fetch the latest entity from storage..
	 */
	public void refresh(T entity);
}
