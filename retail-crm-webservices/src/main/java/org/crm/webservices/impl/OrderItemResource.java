package org.crm.webservices.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.crm.entities.OrderItem;
import org.crm.services.api.OrderItemService;
import org.crm.webservices.api.OrderItemWebService;
import org.crm.webservices.dto.OrderItemInfoDto;
import org.crm.webservices.mapping.ExtendedDozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("OrderItemResource")
public class OrderItemResource implements OrderItemWebService {
	
	@Autowired
	private ExtendedDozerBeanMapper orderDataMapper;
	
	@Autowired
	private OrderItemService orderItemService;

	@Override
	@GET
	@Path("ByOrderId/{orderId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<OrderItemInfoDto> findOrderItemsByOrderId(@PathParam("orderId")Integer orderId) {
		List<OrderItem> orderItems=orderItemService.findAllOrderItemsByOrderId(orderId);
		List<OrderItemInfoDto> orderItemInfoDtos= orderDataMapper.map(orderItems, OrderItemInfoDto.class);
		return orderItemInfoDtos;
	}

	@Override
	public void addOrderItemByOrderId(OrderItemInfoDto orderItemInfoDto,
			Integer orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrderItemByOrderId(OrderItemInfoDto orderItemInfoDto,
			Integer orderId) {
		// TODO Auto-generated method stub
		
	}

}
