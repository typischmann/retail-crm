package org.crm.dao.model;

import java.util.List;

import org.crm.entities.Employee;
import org.crm.entities.Warehouse;

public interface WarehouseDao extends AbstractGenericDao<Integer, Warehouse> {

	
	/**
	 * 
	 * @param manager
	 * @return
	 */
	public List<Warehouse> findWarehouseByManager(Employee manager);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Warehouse findWarehouseByName(String name);
	
	/**
	 * 
	 * @param departmentId
	 * @return
	 */
	public Warehouse findWarehouseByDepartmentId(Integer departmentId);

}
