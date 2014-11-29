package org.crm.dao.model;

import java.util.List;

import org.crm.entities.Department;

public interface DepartmentDao {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Department findDepartmentById(Integer id);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<Department> findDepartmentsByName(String name);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Department> findSubDepartmentsByParentId(Integer id);

}
