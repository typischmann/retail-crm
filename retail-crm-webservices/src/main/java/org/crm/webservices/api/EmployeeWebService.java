package org.crm.webservices.api;

import org.crm.entities.Employee;
import org.crm.webservices.dto.EmployeeInfoDto;

import java.sql.Date;
import java.util.List;

/**
 * Created by Dachuan Zhao on 2015/3/14.
 */
public interface EmployeeWebService {
    /**
     *
     * @param id the unique id of the employee.
     * @return the matched employee object.
     */
    EmployeeInfoDto findEmployeeById(int id);
    /**
     *
     * @return all employees.
     */
    List<EmployeeInfoDto> findAllEmployeesSortedByName();

    /**
     *
     * @param firstName firstName.
     * @param secondName secondName.
     * @return the matching employees.
     */
    List<EmployeeInfoDto> findEmployeesByFullName(String firstName, String secondName);

    /**
     *
     * @param startDate hire start date in milliseconds.
     * @param endDate fire end date in milliseconds.
     * @return the matching employees.
     */
    List<EmployeeInfoDto> findEmployeesBetweenDurationAndSortedByName(long startDate, long endDate);

    /**
     * POST method
     * @param employee
     * @return the employee which got created.
     */
    EmployeeInfoDto createEmployee(Employee employee);

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
