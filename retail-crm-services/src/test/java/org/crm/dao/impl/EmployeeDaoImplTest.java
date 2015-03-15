package org.crm.dao.impl;

import org.crm.dao.model.EmployeeDao;
import org.crm.entities.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:app-context.xml"})
@Transactional
public class EmployeeDaoImplTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void findEmployeeByFullNameShould() {
        List<Employee> employees = employeeDao.findEmployeesByFullName("foo", "nothing");
        assertTrue(employees.isEmpty());

        employees = employeeDao.findEmployeesByFullName("晓霞", "曾");
        assertTrue(employees.size() == 1);
        assertTrue(employees.get(0).getFirstName().equals("晓霞"));
    }

    @Test
    public void findEmployBySortedNameShould() {
        List<Employee> employees = employeeDao.findAllEmployeesSortedByName();
        assertTrue(employees.size() == 2);
    }


    @Test
    public void findEmployeesBySecondNameAndSortedByFirstNameShould() {
        List<Employee> employees = employeeDao.findEmployeesBySecondNameAndSortedByFirstName("foo");
        assertTrue(employees.isEmpty());
    }

    @Test
    public void findEmployeesBetweenDurationAndSortedByNameShould() {
        // date doesn't have endDate.
        Date startDate = new Date(0);
        Date endDate = new Date(System.currentTimeMillis());
        List<Employee> employees = employeeDao.findEmployeesBetweenDurationAndSortedByName(startDate, endDate);
        assertTrue(employees.isEmpty());

        employees = employeeDao.findEmployeesBetweenDurationAndSortedByName(endDate, startDate);
        assertTrue(employees.isEmpty());
    }

    @Test
    public void findEmployeesAfterStartDateShould() {
        Date startDate = new Date(0);
        List<Employee> employees = employeeDao.findEmployeesAfterStartDate(startDate);
        assertTrue(employees.size() == 2);

        // 2016 epoch time
        startDate = new Date(1458002889000l);
        employees = employeeDao.findEmployeesAfterStartDate(startDate);
        assertTrue(employees.isEmpty());
    }

    @Test
    public void findEmployeesAfterEndDateShould() {
        // data in DB doesn't contain the end date, so all queries are empty for now.
        // 2016 epoch time
        Date endDate = new Date(1458002889000l);
        List<Employee> employees = employeeDao.findEmployeesAfterEndDate(endDate);
        assertTrue(employees.isEmpty());

        endDate = new Date(0);
        employees = employeeDao.findEmployeesAfterEndDate(endDate);
        assertTrue(employees.isEmpty());
    }
}