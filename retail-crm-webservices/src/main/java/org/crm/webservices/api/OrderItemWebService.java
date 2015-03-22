package org.crm.webservices.api;

import java.util.List;

import org.crm.webservices.dto.OrderItemInfoDto;

public interface OrderItemWebService {
	
	/**
	 * 
	 * @param orderId
	 * @return
	 */
	public List<OrderItemInfoDto> findOrderItemsByOrderId(Integer orderId);
	
	public void addOrderItemByOrderId(OrderItemInfoDto orderItemInfoDto,Integer orderId);
	
	public void updateOrderItem(OrderItemInfoDto orderItemInfoDto);

}
