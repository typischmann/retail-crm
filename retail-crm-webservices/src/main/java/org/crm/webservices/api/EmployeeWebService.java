package org.crm.webservices.api;

import org.crm.entities.Employee;

import java.sql.Date;
import java.util.List;

/**
 * Created by Dachuan Zhao on 2015/3/14.
 */
public interface EmployeeWebService {
    /**
     *
     * @return all employees.
     */
    List<Employee> findAllEmployeesSortedByName();

    /**
     *
     * @param firstName firstName.
     * @param secondName secondName.
     * @return the matching employees.
     */
    List<Employee> findEmployeesByFullName(String firstName, String secondName);

    /**
     *
     * @param startDate hire start date in milliseconds.
     * @param endDate fire end date in milliseconds.
     * @return the matching employees.
     */
    List<Employee> findEmployeesBetweenDurationAndSortedByName(long startDate, long endDate);

    /**
     * POST method
     * @param employee
     * @return the employee which got created.
     */
    Employee createEmployee(Employee employee);

    /**
     * POST method.
     * @param employee the updated employee.
     * @return true or false.
     */
    boolean updateEmployee(Employee employee);

    /**
     * POST method.
     * @param employee the employee which is should be deleted.
     * @return true or false.
     */
    boolean deleteEmployee(Employee employee);
}
