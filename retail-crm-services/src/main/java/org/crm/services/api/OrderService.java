package org.crm.services.api;

import java.sql.Timestamp;
import java.util.List;

import org.crm.entities.Employee;
import org.crm.entities.Order;
import org.crm.entities.Order.OrderType;

public interface OrderService {
	/**
	 * 
	 * @param orderType
	 * @param employee
	 * @return
	 */
	public Order createRootOrder(OrderType orderType, Employee employee);
	
	/**
	 * 
	 * @param order
	 * @return
	 */
	public Order updateOrSaveOrder(Order order);
	
	/**
	 * 
	 * @param parent
	 * @param orderType
	 * @param employee
	 * @return
	 */
	public Order createSubOrderForParentOrder(Order parent, OrderType orderType, Employee employee);
	
	/**
	 * 
	 * @param order
	 */
	public void removeOrder(Order order);
	
	/**
	 * 
	 * @param orderId
	 * @return
	 */
	public Order findOrderById(Integer orderId);
	
	/**
	 * 
	 * @param startDate
	 * @return
	 */
	public List<Order> findOrdersCreatedAfterStartDate(Timestamp startDate);
	
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<Order> findOrdersCreatedBetweenTimeInterval(Timestamp startDate, Timestamp endDate);

}
