package org.crm.dao;

import javax.transaction.Transactional;




import org.crm.dao.model.OrderDao;
import org.crm.entities.Department;
import org.crm.entities.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:app-context.xml"})
@Transactional
public class OrderDaoTest {
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
		//Assert.assertEquals(order.getOrderItems().get(0).getProduct());
	}

}
