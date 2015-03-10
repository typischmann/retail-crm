package org.crm.dao.impl;

import org.crm.entities.Employee;
import org.crm.util.JsonSerializer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:app-context.xml"})
@Transactional
public class EmployeeDaoImplTest {

    @Autowired
    private EmployeeDaoImpl employeeDao;

    @Test
    public void findEmployeeByFullNameShould()
    {
        List<Employee> employees = employeeDao.findEmployeesByFullName("foo","nothing");
        assertTrue(employees.isEmpty());

        employees = employeeDao.findEmployeesByFullName("晓霞", "曾");
        assertTrue(employees.size() == 1);
        assertTrue(employees.get(0).getFirstName().equals("晓霞"));
    }

    @Test
    public void findEmployBySortedNameShould()
    {
        List<Employee> employees = employeeDao.findAllEmployeesSortedByName();
        assertTrue(employees.size() == 2);
    }

}