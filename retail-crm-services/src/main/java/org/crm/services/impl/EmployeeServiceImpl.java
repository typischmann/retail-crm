package org.crm.services.impl;

import org.crm.dao.model.EmployeeDao;
import org.crm.entities.Employee;
import org.crm.services.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by Dachuan Zhao on 2015/3/12.
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> findAllEmployeesSortedByName() {
        return employeeDao.findAllEmployeesSortedByName();
    }

    @Override
    public List<Employee> findEmployeesByFullName(String firstName, String secondName) {
        return employeeDao.findEmployeesByFullName(firstName, secondName);
    }

    /**
     * @param secondName second name
     * @return the matching employees.
     */
    @Override
    public List<Employee> findEmployeesBySecondNameAndSortedByFirstName(String secondName) {
        return employeeDao.findEmployeesBySecondNameAndSortedByFirstName(secondName);
    }

    /**
     * @param firstName fristName;
     * @return the matching employees;
     */
    @Override
    public List<Employee> findEmployeesByFirstNameAndSortedBySecondName(String firstName) {
        return employeeDao.findEmployeesByFirstNameAndSortedBySecondName(firstName);
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
