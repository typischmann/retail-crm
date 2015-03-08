package org.crm.dao.model;

import java.util.List;

import org.crm.entities.OrderItem;

public interface OrderItemDao {
	
	/**
	 * 
	 * @param orderId
	 * @return
	 */
	public List<OrderItem> findOrderItemsByOrderId(Integer orderId);
}
