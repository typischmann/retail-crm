package org.crm.services.api;

import java.util.List;

import org.crm.entities.OrderItem;

public interface OrderItemService {

	/**
	 * 
	 * @param itemId
	 * @return
	 */
	public OrderItem findOrderItemById(Integer itemId);
	
	/**
	 * 
	 * @param orderId
	 * @return
	 */
	public List<OrderItem> findAllOrderItemsByOrderId(Integer orderId);
	
	/**
	 * 
	 * @param orderItem
	 * @return
	 */
	public OrderItem saveOrUpdateOrderItem(OrderItem orderItem);
	
	/**
	 * 
	 * @param orderItem
	 */
	public void removeOrderItem(OrderItem orderItem);
}
