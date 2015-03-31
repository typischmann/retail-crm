package org.crm.webservices.impl;

import org.crm.dao.model.EmployeeDao;
import org.crm.webservices.dto.EmployeeInfoDto;
import org.crm.webservices.mapping.ExtendedDozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

/**
 * Created by Dachuan Zhao on 2015/3/14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:app-context.xml"})
@Transactional
public class EmployeeResourceTest {
    @Autowired
    private EmployeeDao employeeDao;
}
