package org.crm.dao.model;

import java.util.List;

import org.crm.entities.OrderItem;

public interface OrderItemDao {

    /**
     *
     * @param orderId the unique id for each order.
     * @return a list of order item.
     */
	public List<OrderItem> findOrderItemsByOrderId(Integer orderId);
}
