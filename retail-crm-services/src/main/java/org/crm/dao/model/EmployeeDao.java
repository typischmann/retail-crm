package org.crm.dao.model;

import java.sql.Date;
import java.util.List;

import org.crm.entities.Employee;

public interface EmployeeDao {
	
	/**
	 * 
	 * @return list of all employees which are sorted by name in alphabetical order.
	 */
	public List<Employee> findAllEmployeesSortedByName();
	
	/**
	 * 
	 * @param firstName FirstName.
	 * @param secondName SecondName.
	 * @return the matched list of employees.
	 */
	public List<Employee> findEmployeesByFullName(String firstName, String secondName);
	
	/**
	 * 
	 * @param secondName SecondName
     * @return the matched list of employees.
	 */
	public List<Employee> findEmployeesBySecondNameAndSortedByFirstName(String secondName);
	
	/**
	 * 
	 * @param startDate hired starting date.
	 * @param endDate fired ending date or null.
     * @return the matched list of employees.
	 */
	public List<Employee> findEmployeesBetweenDurationAndSortedByName(Date startDate, Date endDate);
	
	/**
	 * 
	 * @param startDate hired start date.
     * @return the matched list of employees.
	 */
	public List<Employee> findEmployeesAfterStartDate(Date startDate);
	
	/**
	 * 
	 * @param endDate hired ending date, null meaning hiring employees so far.
     * @return the matched list of employees.
	 */
	public List<Employee> findEmployeesAfterEndDate(Date endDate);

}
