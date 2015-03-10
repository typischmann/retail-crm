package org.crm.webservices.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.crm.entities.Department;
import org.crm.entities.Employee;
import org.crm.entities.Order;
import org.crm.entities.Order.OrderType;
import org.crm.services.api.OrderService;
import org.crm.webservices.api.OrderWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("OrderResource")
public class OrderResource implements OrderWebService{

	@Autowired
	private OrderService orderService;	
	
	@GET
	@Path("ById/{Id}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Order findOrderById(@PathParam("Id") Integer orderId){
		Order order = orderService.findOrderById(orderId);
		return order;
	}
	
	
	@GET
	@Path("ByEmloyee")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Order> findAllOrdersByEmployee(Employee employee) {
		
		return null;
	}

	@GET
	@Path("ByDepartment")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Order> findAllOrdersByDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Order createRootOrder(OrderType orderType, Employee employee) {
		return orderService.createRootOrder(orderType, employee);
	}
	
	

}
