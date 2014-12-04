package org.crm.weka.dao;


import java.io.File;
import java.util.Enumeration;

import org.crm.weka.dao.api.GenericWekaDao;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import weka.core.Attribute;
import weka.core.Instances;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:app-context.xml"})
public class GenericWekaDaoRIT {
	
	@Autowired
	private GenericWekaDao genericWekaDao;
	
	private static String queryFilePath;
	
	@BeforeClass
	public static void prepare(){
		queryFilePath="src/main/resources/sql/departments.sql";
	}
	
	@Test
	public void selectQueryGenericWekaDaoTest() throws Exception{
		
		Instances instances=genericWekaDao.getInstances("select * from dbo.department");
		
		Assert.assertTrue(instances.size() == 30);
	}
	
	@Test
	public void selectQueryGenericWekaDaoLoadQueryWithoutParameterTest() throws Exception{
		
		genericWekaDao.loadQueryFile(new File(queryFilePath));
		Instances instances=genericWekaDao.getInstances();	
		Assert.assertTrue(instances.size() == 30);
		
		Enumeration<Attribute> enu=instances.enumerateAttributes();
		while(enu.hasMoreElements()){
			Attribute attr=enu.nextElement();
			System.out.println(attr.name()+" position: "+attr.index());
		}
		
	}

}
