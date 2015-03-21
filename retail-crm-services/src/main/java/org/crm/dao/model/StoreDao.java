package org.crm.dao.model;

import org.crm.entities.Employee;
import org.crm.entities.Store;

public interface StoreDao extends AbstractGenericDao<Integer, Store> {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Store findStoreById(Integer id);

	/**
	 * 
	 * @param manager
	 * @return
	 */
	public Store findStoreByManager(Employee manager);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Store findStoreByName(String name);
}
