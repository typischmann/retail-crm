package org.crm.dao.model;

import java.util.List;

import org.crm.entities.Employee;
import org.crm.entities.Warehouse;

public interface WarehouseDao {
	
	public Warehouse getWarehouseById(Integer id);
	
	public List<Warehouse> getWarehouseByManager(Employee manager);
	
	public Warehouse getWarehouseByName(String name);

}
