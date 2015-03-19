package org.crm.webservices.mapping;

import javax.transaction.Transactional;

import org.crm.dao.model.OrderDao;
import org.crm.entities.Order;
import org.crm.webservices.dto.OrderInfoDto;
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

		OrderInfoDto orderInfo = orderDataMapper.map(order,OrderInfoDto.class);
		Assert.assertTrue(orderInfo.getId()==order.getId());
		Assert.assertTrue(orderInfo.getParentOrderId()==order.getParentOrder().getId());
		System.out.println(orderInfo.getOrderType());
		System.out.println(orderInfo.getCreateTs().getTime());
	}
	
	@Test
	public void MappingOrderInfoDtoBackToOrderTest(){
		Order order = orderDao.find(10000001);
		Assert.assertNotNull(order);

		OrderInfoDto orderInfoDto = orderDataMapper.map(order,OrderInfoDto.class);
		Assert.assertTrue(orderInfoDto.getId()==order.getId());
		Assert.assertTrue(orderInfoDto.getParentOrderId()==order.getParentOrder().getId());
		Assert.assertTrue(order.isIs_paid());
		orderInfoDto.setPaid(false);
		orderDataMapper.map(orderInfoDto, order);
		Assert.assertFalse(order.isIs_paid());
		
	}

}
