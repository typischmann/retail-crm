package org.crm.dao.model;

public interface GenericDao<T> {
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public T persist(T obj);
	
	/**
	 * 
	 * @param obj
	 */
	public void remove(Object obj);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public T find(Object id);
}
