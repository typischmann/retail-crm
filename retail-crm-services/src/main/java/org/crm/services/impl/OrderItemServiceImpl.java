package org.crm.services.impl;


import java.util.List;

import org.crm.dao.model.OrderDao;
import org.crm.dao.model.OrderItemDao;
import org.crm.entities.Order;
import org.crm.entities.OrderItem;
import org.crm.services.api.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderItemService")
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	private OrderItemDao orderItemDao;
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public OrderItem findOrderItemById(Integer itemId) {
		OrderItem orderItem = orderItemDao.find(itemId);
		return orderItem;
	}

	@Override
	public OrderItem saveOrUpdateOrderItem(OrderItem orderItem) {
		OrderItem item = orderItemDao.saveOrUpdate(orderItem);
		return item;
	}

	@Override
	public void removeOrderItem(OrderItem orderItem) {
		orderItemDao.remove(orderItem.getId());
	}

	@Override
	public List<OrderItem> findAllOrderItemsByOrderId(Integer orderId) {
		Order order = orderDao.find(orderId);
		List<OrderItem> items = order.getOrderItems();
		return items;
	}

	@Override
	//TODO: Test for persist/merge cascade between order and order item
	public OrderItem addOrderItemByOrderId(OrderItem orderItem, Integer orderId) {
		Order order = orderDao.find(orderId);
		orderItem.setParentOrder(order);
		orderItemDao.persist(orderItem);
		order.getOrderItems().add(orderItem);
		orderDao.saveOrUpdate(order);
		return orderItem;
	}
	
	
}
