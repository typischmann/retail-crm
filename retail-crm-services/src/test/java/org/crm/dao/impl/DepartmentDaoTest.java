package org.crm.dao.impl;



import java.util.List;

import javax.transaction.Transactional;

import org.crm.dao.model.DepartmentDao;
import org.crm.entities.Department;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:app-context.xml"})
@Transactional
public class DepartmentDaoTest {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Ignore
	@Test
	public void findDepartmentByIdTest(){
		Department dep=departmentDao.findDepartmentById( 7);
		Assert.assertEquals(dep.getName(), "NAR");
		Assert.assertEquals(dep.getName_en(), "North America Retail");
		
		Assert.assertTrue(dep.getParent().getId()==1);
		Assert.assertEquals(dep.getParent().getName(), "CEO");
		Assert.assertEquals(dep.getParent().getName_en(), "Chief Executing Officer");		
		Assert.assertTrue(dep.getParent().getSubDepartments().size()==10);
		Assert.assertNull(dep.getParent().getParent());
	}

	@Ignore
	@Test
	public void findDepartmentsByNameTest(){
		List<Department> deps=departmentDao.findDepartmentsByName("NAR");
		Assert.assertTrue(deps.size()==1);
		
		Department dep=deps.get(0);
		Assert.assertTrue(dep.getId()==7);
		Assert.assertEquals(dep.getName_en(), "North America Retail");
		
		Assert.assertTrue(dep.getParent().getId()==1);
		Assert.assertEquals(dep.getParent().getName(), "CEO");
		Assert.assertEquals(dep.getParent().getName_en(), "Chief Executing Officer");		
		Assert.assertTrue(dep.getParent().getSubDepartments().size()==10);
		Assert.assertNull(dep.getParent().getParent());
	}
	
	@Test
	public void findSubDepartmentsByParentIdTest(){
		List<Department> deps=departmentDao.findSubDepartmentsByParentId(7);
		Assert.assertTrue(deps.size()==5);
	}
}
