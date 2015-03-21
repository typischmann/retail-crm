package org.crm.dao.model;

import java.sql.Date;
import java.util.List;

import org.crm.entities.Employee;

public interface EmployeeDao extends AbstractGenericDao<Integer, Employee> {

	/**
	 * 
	 * @return
	 */
	public List<Employee> findAllEmployeesSortedByName();

	/**
	 * 
	 * @param firstName
	 * @param secondName
	 * @return
	 */
	public List<Employee> findEmployeesByFullName(String firstName,
			String secondName);

	/**
	 * 
	 * @param secondName
	 *            secondName.
	 * @return the matching employees.
	 */
	public List<Employee> findEmployeesBySecondNameAndSortedByFirstName(
			String secondName);

	/**
	 * 
	 * @param firstName
	 *            firstName.
	 * @return the matching employees.
	 */
	public List<Employee> findEmployeesByFirstNameAndSortedBySecondName(
			String firstName);

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<Employee> findEmployeesBetweenDurationAndSortedByName(
			Date startDate, Date endDate);

	/**
	 * 
	 * @param startDate
	 * @return
	 */
	public List<Employee> findEmployeesAfterStartDate(Date startDate);

	/**
	 * 
	 * @param endDate
	 * @return
	 */
	public List<Employee> findEmployeesAfterEndDate(Date endDate);

}
