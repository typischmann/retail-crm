package org.crm.weka.dao;

import java.io.File;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

import weka.core.Instances;
import weka.experiment.InstanceQuery;

public class InstanceQueryTest {
	/**
	 * specific data types (The code for Java Data Type)
	 * string, getString() = 0; -->nominal
	 * boolean, getBoolean() = 1;  -->nominal
	 * double, getDouble() = 2; -->numeric
	 * byte, getByte() = 3; -->numeric
	 * short, getByte() = 4; -->numeric
	 * int, getInteger = 5; -->numeric
	 * long, getLong() = 6; -->numeric
	 * float, getFloat() = 7; -->numeric
	 * date, getDate() = 8; -->Date
	 * text, getString() = 9; -->string
	 * time, getTime() = 10; -->date
	 */
	
	
	
	@Test
	public void selectQueryTest() throws Exception{
		Properties props=new Properties();
		props.setProperty("jdbcDriver", "org.postgresql.Driver");
		props.setProperty("serial", "5");
		props.setProperty("varchar", "0");
		props.setProperty("int4", "5");
		
		InstanceQuery instanceQuery=new InstanceQuery();
		instanceQuery.initialize(props);
		instanceQuery.setDatabaseURL("jdbc:postgresql://localhost:5432/Test");
		instanceQuery.setUsername("postgres");
		instanceQuery.setPassword("test");
		//instanceQuery.execute("set");
		Instances instances=instanceQuery.retrieveInstances("select * from dbo.department");
		
		Assert.assertTrue(instances.size() == 30);
		
		
	}
	
	@Test
	public void selectQueryTestWithPropertyFile() throws Exception{
		
		InstanceQuery instanceQuery=new InstanceQuery();
		File propsFile=new File("src/main/resources/weka/weka-database.props");
		Assert.assertTrue(propsFile.exists());
		instanceQuery.initialize(propsFile);
		instanceQuery.setUsername("postgres");
		instanceQuery.setPassword("test");
		
		Instances instances=instanceQuery.retrieveInstances("select * from dbo.department");
		
		Assert.assertTrue(instances.size() == 30);
		
	}

}
