package org.crm.services.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.crm.dao.model.OrderDao;
import org.crm.entities.Employee;
import org.crm.entities.Order;
import org.crm.entities.Order.OrderStatus;
import org.crm.entities.Order.OrderType;
import org.crm.entities.OrderItem;
import org.crm.services.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order createRootOrder(OrderType orderType, Employee employee) {
		Order order = this.createOrder(orderType, employee);
		order.setRoot(true);
		order.setParentOrder(null);
		this.orderDao.persist(order);
		return order;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order saveOrUpdateOrder(Order order) {
		return orderDao.saveOrUpdate(order);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order createSubOrderForParentOrder(Order parent, OrderType orderType,
			Employee employee) {
		Order order = this.createOrder(orderType, employee);
		order.setRoot(false);
		order.setParentOrder(parent);
		parent.getSubOrders().add(order);
		orderDao.persist(order);
		return order;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeOrder(Order order) {
		orderDao.remove(order.getId());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void cancellOrderById(Integer orderId) {
		Order order = orderDao.find(orderId);
		for(OrderItem orderItem : order.getOrderItems()){
			//TODO: changing the inventory change record status to cancell
		}
		
	}

	/**
	 * Set the common configuration for a order.
	 * @param orderType   The expected order type
	 * @param employee	  The information of responsible user
	 * @return a new order entity
	 */
	private Order createOrder(OrderType orderType, Employee employee){
		Order order = new Order();
		order.setOrderType(orderType);
		order.setResponsibleDepartment(employee.getDepartment());
		order.setResponsibleEmployee(employee);
		order.setPaid(false);
		order.setOrderStatus(OrderStatus.CREATED);
		order.setCreateTs(new Timestamp(new Date().getTime()));
		order.setDeltaTs(new Timestamp(new Date().getTime()));
		return order;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order findOrderById(Integer orderId) {
		return orderDao.find(orderId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> findOrdersCreatedAfterStartDate(Timestamp startDate) {
		return orderDao.findOrdersCreatedAfterStartDate(startDate);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> findOrdersCreatedBetweenTimeInterval(
			Timestamp startDate, Timestamp endDate) {
		return orderDao.findOrdersCreatedBetweenTimeInterval(startDate, endDate);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order addOrderItemByOrderId(Integer orderId, OrderItem orderItem) {
		Order order = orderDao.find(orderId);
		order.getOrderItems().add(orderItem);	
		//TODO: Add Inventory Change Record accordingly
		return orderDao.saveOrUpdate(order);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order deleteOrderItemByOrderId(Integer orderId, Integer orderItemId) {
		Order order = orderDao.find(orderId);
		for(OrderItem item : order.getOrderItems()){
			if(item.getId()==orderItemId){
				order.getOrderItems().remove(item);
			}
		}
		return orderDao.saveOrUpdate(order);
	}
	
	
}
