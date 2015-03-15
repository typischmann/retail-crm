package org.crm.services.api;

import org.crm.entities.Department;
import org.crm.entities.Employee;

import java.sql.Date;
import java.util.List;

/**
 * Created by Dachuan Zhao on 2015/3/12.
 */
public interface EmployeeService {

    /**
     *
     * @return the list of employees sorted by first name and second name..
     */
    List<Employee> findAllEmployeesSortedByName();

    /**
     *
     * @param firstName first name.
     * @param secondName second name.
     * @return the matching employees.
     */
    List<Employee> findEmployeesByFullName(final String firstName, final String secondName);

    /**
     *
     * @param startDate the time after the employee was hired.
     * @return the list employees.
     */
    List<Employee> findEmployeesAfterStartDate(final Date startDate);

    /**
     *
     * @param endDate the time before the employee left.
     * @return the list employees.
     */
    List<Employee> findEmployeesAfterEndDate(final Date endDate);

    /**
     *
     * @param startDate the time after the employee was hired.
     * @param endDate the time before the employee left.
     * @return the list employees.
     */
    List<Employee> findEmployeesBetweenDurationAndSortedByName(final Date startDate, final Date endDate);
}
