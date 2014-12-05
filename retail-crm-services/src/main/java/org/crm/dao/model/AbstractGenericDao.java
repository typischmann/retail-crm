package org.crm.dao.model;

import java.io.Serializable;

public interface AbstractGenericDao<PK extends Serializable, T extends Serializable> {
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public T update(T entity);
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public T persist(T entity);
	
	/**
	 * 
	 * @param primaryKey
	 */
	public void remove(PK primaryKey);
	
	/**
	 * 
	 * @param primaryKey
	 * @return
	 */
	public T find(PK primaryKey);
	
	/**
	 * 
	 * @param entity
	 */
	public void refresh(T entity);
}
