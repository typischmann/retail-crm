package org.crm.dao.model;

import java.util.List;

import org.crm.entities.OrderItem;

public interface OrderItemDao extends AbstractGenericDao<Integer, OrderItem> {
	
	/**
	 * 
	 * @param orderId
	 * @return
	 */
	public List<OrderItem> findOrderItemsByOrderId(Integer orderId);
}
