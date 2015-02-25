package org.crm.services.api;

import org.crm.entities.Employee;
import org.crm.entities.Order;
import org.crm.entities.Order.OrderType;

public interface OrderService {
	
	public Order createRootOrder(OrderType orderType, Employee employee);
	
	public Order updateOrSaveOrder(Order order);
	
	public Order createSubOrderForParentOrder(Order parent, OrderType orderType, Employee employee);
	
	public void removeOrder(Order order);

}
