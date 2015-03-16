package org.crm.services.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.crm.dao.model.OrderDao;
import org.crm.entities.Employee;
import org.crm.entities.Order;
import org.crm.entities.Order.OrderStatus;
import org.crm.entities.Order.OrderType;
import org.crm.services.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	/**
	 * {@inheritDoc}
	 */
	public Order createRootOrder(OrderType orderType, Employee employee) {
		Order order = this.createOrder(orderType, employee);
		order.setIs_root(true);
		order.setParentOrder(null);
		this.orderDao.persist(order);
		return order;
	}

	/**
	 * {@inheritDoc}
	 */
	public Order updateOrSaveOrder(Order order) {
		return orderDao.saveOrUpdate(order);
	}

	/**
	 * {@inheritDoc}
	 */
	public Order createSubOrderForParentOrder(Order parent, OrderType orderType,
			Employee employee) {
		Order order = this.createOrder(orderType, employee);
		order.setIs_root(false);
		order.setParentOrder(parent);
		parent.getSubOrders().add(order);
		orderDao.persist(order);
		return order;
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeOrder(Order order) {
		orderDao.remove(order.getId());
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
		order.setIs_paid(false);
		order.setOrderStatus(OrderStatus.CREATED);
		order.setCreate_ts(new Timestamp(new Date().getTime()));
		order.setDelta_ts(new Timestamp(new Date().getTime()));
		return order;
	}

	/**
	 * {@inheritDoc}
	 */
	public Order findOrderById(Integer orderId) {
		return orderDao.find(orderId);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> findOrdersCreatedAfterStartDate(Timestamp startDate) {
		return orderDao.findOrdersCreatedAfterStartDate(startDate);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> findOrdersCreatedBetweenTimeInterval(
			Timestamp startDate, Timestamp endDate) {
		return orderDao.findOrdersCreatedBetweenTimeInterval(startDate, endDate);
	}

}
