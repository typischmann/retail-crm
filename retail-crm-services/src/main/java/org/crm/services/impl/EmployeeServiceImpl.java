package org.crm.services.impl;

import org.crm.dao.model.EmployeeDao;
import org.crm.entities.Employee;
import org.crm.services.api.EmployeeService;

import java.sql.Date;
import java.util.List;

/**
 * Created by Dachuan Zhao on 2015/3/12.
 */
public class EmployeeServiceImpl implements EmployeeService
{
    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(final EmployeeDao employeeDao)
    {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAllEmployeesSortedByName() {
        return employeeDao.findAllEmployeesSortedByName();
    }

    @Override
    public List<Employee> findEmployeesByFullName(String firstName, String secondName) {
        return employeeDao.findEmployeesByFullName(firstName, secondName);
    }

    @Override
    public List<Employee> findEmployeesAfterStartDate(Date startDate) {
        return employeeDao.findEmployeesAfterStartDate(startDate);
    }

    @Override
    public List<Employee> findEmployeesAfterEndDate(Date endDate) {
        return employeeDao.findEmployeesAfterEndDate(endDate);
    }

    @Override
    public List<Employee> findEmployeesBetweenDurationAndSortedByName(Date startDate, Date endDate) {
        if(endDate.before(startDate))
        {
            throw new IllegalArgumentException(endDate.toString() + " is earlier than " + startDate.toString());
        }
        return employeeDao.findEmployeesBetweenDurationAndSortedByName(startDate, endDate);
    }
}
