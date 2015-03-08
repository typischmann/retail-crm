package org.crm.dao.impl;



import org.crm.dao.model.DepartmentDao;
import org.crm.entities.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:app-context.xml"})
@Transactional
public class DepartmentDaoTest {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Test
	public void findDepartmentByIdTest(){
		Department dep=departmentDao.findDepartmentById( 7);
		assertEquals(dep.getName(), "NAR");
		assertEquals(dep.getName_en(), "North America Retail");
		
		assertTrue(dep.getParent().getId() == 1);
		assertEquals(dep.getParent().getName(), "CEO");
		assertEquals(dep.getParent().getName_en(), "Chief Executing Officer");
		assertTrue(dep.getParent().getSubDepartments().size() == 10);
		assertNull(dep.getParent().getParent());
	}

	@Test
	public void findDepartmentsByNameTest(){
		List<Department> deps=departmentDao.findDepartmentsByName("NAR");
		assertTrue(deps.size() == 1);
		
		Department dep=deps.get(0);
		assertTrue(dep.getId() == 7);
		assertEquals(dep.getName_en(), "North America Retail");
		
		assertTrue(dep.getParent().getId() == 1);
		assertEquals(dep.getParent().getName(), "CEO");
		assertEquals(dep.getParent().getName_en(), "Chief Executing Officer");		
		assertTrue(dep.getParent().getSubDepartments().size() == 10);
		assertNull(dep.getParent().getParent());
	}
	
	@Test
	public void findSubDepartmentsByParentIdTest(){
		List<Department> deps=departmentDao.findSubDepartmentsByParentId(7);
		assertTrue(deps.size() == 5);
	}
}
