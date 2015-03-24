package org.crm.dao.impl;

import javax.transaction.Transactional;






import org.crm.dao.model.OrderDao;
import org.crm.entities.Department;
import org.crm.entities.Order;
import org.crm.entities.Order.OrderStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:app-context.xml"})
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback = true)
@Transactional
public class OrderDaoImplTest {
	@Autowired
	private OrderDao orderDao;
	
	@Test
	public void findOrderByIdTest(){
		Order order = orderDao.find(10000001);
		Assert.assertNotNull(order);
		Department department=order.getResponsibleDepartment();
		Assert.assertNotNull(department);
		String departmentName = department.getName();
		Assert.assertNotNull(departmentName);
		Assert.assertTrue(order.getOrderItems().size()==1);
		System.out.println(order.getOrderItems().get(0).getProduct().getProductName());
		System.out.println(order.getOrderItems().get(0).getProduct().getProductCategory().getName());
		System.out.println(order.getOrderItems().get(0).getProduct().getProductCategory().getName());
		System.out.println(order.getOrderItems().get(0).getPrice().getPriceValue());
		//Assert.assertEquals(order.getOrderItems().get(0).getProduct());
	}
	
	@Test
	public void BooleanConverterTest(){
		Order order1 = orderDao.find(10000001);
		Assert.assertNotNull(order1);
		Assert.assertTrue(order1.isRoot());
		order1.setRoot(false);
		order1.setOrderStatus(OrderStatus.CANCELLED);
		orderDao.saveOrUpdate(order1);
		//second order to see if the false boolean value was converted to 'N' and stored in database
		Order order2 = orderDao.find(10000001);
		Assert.assertNotNull(order2);
		Assert.assertTrue(order2.getOrderStatus()==OrderStatus.CANCELLED);
		Assert.assertFalse(order2.isRoot());
		//Roll back
		order2.setRoot(true);
		order2.setOrderStatus(OrderStatus.EXECUTED);
		orderDao.saveOrUpdate(order2);
	}

}
