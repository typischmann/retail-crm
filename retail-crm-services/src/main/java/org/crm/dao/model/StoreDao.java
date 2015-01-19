package org.crm.dao.model;

import org.crm.entities.Employee;
import org.crm.entities.Store;

public interface StoreDao {
	
	public Store findStoreById(Integer id);

	public Store findStoreByManager(Employee manager);
	
	public Store findStoreByName(String name);
}
