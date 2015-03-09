package org.crm.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.crm.dao.model.OrderItemDao;
import org.crm.entities.Order;
import org.crm.entities.OrderItem;
import org.crm.entities.Product;

public class OrderItemDaoImpl extends AbstractGenericDaoImpl<Integer, OrderItem>
		implements OrderItemDao {
	
	public OrderItemDaoImpl(){
		super(OrderItem.class);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<OrderItem> findOrderItemsByOrderId(Integer orderId) {
		TypedQuery<OrderItem> query=em.createNamedQuery(OrderItem.findOrderItemsByOrderId, OrderItem.class);
		query.setParameter("orderId", orderId);
		return query.getResultList();
	}

}
