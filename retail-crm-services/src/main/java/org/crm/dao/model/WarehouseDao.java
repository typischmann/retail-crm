package org.crm.dao.model;

import java.util.List;

import org.crm.entities.Employee;
import org.crm.entities.Warehouse;

public interface WarehouseDao extends AbstractGenericDao<Integer, Warehouse> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Warehouse getWarehouseById(Integer id);
	
	/**
	 * 
	 * @param manager
	 * @return
	 */
	public List<Warehouse> getWarehouseByManager(Employee manager);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Warehouse getWarehouseByName(String name);

}
