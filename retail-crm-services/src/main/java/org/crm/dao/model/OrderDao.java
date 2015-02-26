package org.crm.dao.model;

import java.sql.Timestamp;
import java.util.List;

import org.crm.entities.Department;
import org.crm.entities.Employee;
import org.crm.entities.Order;

public interface OrderDao extends AbstractGenericDao<Integer, Order> {
	
	public List<Order> findAllOrdersByDepartment(Department department);
	
	public List<Order> findAllOrdersByEmployee(Employee employee);
	
	public List<Order> findOrdersCreatedAfterStartDate(Timestamp startDate);
	
	public List<Order> findOrdersCreatedBetweenTimeInterval(Timestamp startDate, Timestamp endDate);
	
}
