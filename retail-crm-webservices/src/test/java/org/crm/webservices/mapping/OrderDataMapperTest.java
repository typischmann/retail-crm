package org.crm.webservices.mapping;

import javax.transaction.Transactional;

import org.crm.dao.model.OrderDao;
import org.crm.entities.Order;
import org.crm.webservices.entity.OrderInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:app-context.xml"})
@Transactional
public class OrderDataMapperTest {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ExtendedDozerBeanMapper orderDataMapper;
	
	@Test
	public void findOrderByIdTest(){
		Order order = orderDao.find(10000001);
		Assert.assertNotNull(order);

		OrderInfo orderInfo = orderDataMapper.map(order,OrderInfo.class);
		Assert.assertTrue(orderInfo.getId()==order.getId());
		Assert.assertTrue(orderInfo.getParentOrderId()==order.getParentOrder().getId());
		System.out.println(orderInfo.getOrderType());
	}

}
