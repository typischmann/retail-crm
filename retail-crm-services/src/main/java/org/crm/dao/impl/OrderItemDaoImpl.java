package org.crm.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.crm.dao.model.OrderItemDao;
import org.crm.entities.OrderItem;
import org.springframework.stereotype.Repository;

@Repository("orderItemDao")
@Transactional
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
