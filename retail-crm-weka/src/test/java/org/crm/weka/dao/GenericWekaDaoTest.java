package org.crm.weka.dao;

import java.io.File;

import org.crm.weka.dao.api.GenericWekaDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import weka.core.Instances;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:app-context.xml"})
public class GenericWekaDaoTest {
	
	@Autowired
	private GenericWekaDao genericWekaDao;
	
	@Test
	public void selectQueryGenericWekaDaoTest() throws Exception{
		
		Instances instances=genericWekaDao.getInstances("select * from dbo.department");
		
		Assert.assertTrue(instances.size() == 30);
	}

}
