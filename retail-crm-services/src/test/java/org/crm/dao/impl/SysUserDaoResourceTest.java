package org.crm.dao.impl;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.crm.dao.model.SysUserDao;
import org.crm.entities.SysUser;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:app-context.xml"})
@Transactional
public class SysUserDaoResourceTest {
	
	@Autowired
	private SysUserDao sysUserDao;

	@Test
	public void authenticateByUnencrptedPassword(){
		Boolean authenticated = sysUserDao.authenticateUserByUserNameAndUserPassword("jibao", "bjy1986717");
		Assert.assertTrue(authenticated);
		authenticated = sysUserDao.authenticateUserByUserNameAndUserPassword("jibao", "ssss");
		Assert.assertFalse(authenticated);
	}
	
	@Test
	public void findSysUserByUsername(){
		SysUser sysUser = sysUserDao.find(23);
		Assert.assertNotNull(sysUser);
	}

}
