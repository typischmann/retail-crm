package org.crm.webservices.api;

import java.util.List;

import org.crm.entities.Department;
import org.crm.entities.Employee;
import org.crm.entities.Order;
import org.crm.entities.Order.OrderType;
import org.crm.webservices.dto.OrderInfoDto;

public interface OrderWebService {

	public OrderInfoDto findOrderById(Integer orderId);

	public List<Order> findAllOrdersByEmployee(Employee employee);

	public List<Order> findAllOrdersByDepartment(Department department);

	public Order createRootOrder(OrderType orderType, Employee employee);

	public List<OrderInfoDto> findOrdersByTimeInterval(Long start, Long end);
	
	public OrderInfoDto updateOrderByDto(OrderInfoDto orderInfoDto);
}
