package org.crm.webservices.api;

import java.util.List;

import org.crm.entities.Department;
import org.crm.entities.Employee;
import org.crm.entities.Order;
import org.crm.entities.Order.OrderType;
import org.crm.webservices.entity.OrderInfo;

public interface OrderWebService {
	
	public Order findOrderById(Integer orderId);
	
	public List<Order> findAllOrdersByEmployee(Employee employee);
	
	public List<Order> findAllOrdersByDepartment(Department department);
	
	public Order createRootOrder(OrderType orderType, Employee employee);

}
