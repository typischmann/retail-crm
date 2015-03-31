package org.crm.service.impl;

import javax.transaction.Transactional;

import org.crm.entities.Order;
import org.crm.entities.Order.OrderStatus;
import org.crm.services.api.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:app-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class OrderServiceImplTest {

	@Autowired
	private OrderService orderService;

	@Test
	public void findOrderByIdTest() {
		Order order1 = orderService.findOrderById(10000001);
		Assert.assertNotNull(order1);
		Assert.assertTrue(order1.isRoot());
		order1.setRoot(false);
		order1.setOrderStatus(OrderStatus.CANCELLED);
		orderService.saveOrUpdateOrder(order1);
		// second order to see if the false boolean value was converted to 'N'
		// and stored in database
		Order order2 = orderService.findOrderById(10000001);
		Assert.assertNotNull(order2);
		Assert.assertTrue(order2.getOrderStatus() == OrderStatus.CANCELLED);
		Assert.assertFalse(order2.isRoot());
		// Roll back
		order2.setRoot(true);
		order2.setOrderStatus(OrderStatus.EXECUTED);
		orderService.saveOrUpdateOrder(order2);
	}

}
