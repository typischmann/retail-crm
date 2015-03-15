package org.crm.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.crm.dao.model.EmployeeDao;
import org.crm.entities.Department;
import org.crm.entities.Employee;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
@Transactional
public class EmployeeDaoImpl extends AbstractGenericDaoImpl<Integer, Employee> implements
		EmployeeDao {
	
	public EmployeeDaoImpl(){
		super(Employee.class);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<Employee> findAllEmployeesSortedByName() {
		TypedQuery<Employee> query=em.createNamedQuery(Employee.findAllEmployeesSortedByName, Employee.class);
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Employee> findEmployeesByFullName(String firstName,
			String secondName) {
		TypedQuery<Employee> query=em.createNamedQuery(Employee.findEmployeesByFullName, Employee.class);
		query.setParameter("firstName", firstName);
		query.setParameter("secondName", secondName);
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Employee> findEmployeesBySecondNameAndSortedByFirstName(
			String secondName) {
		TypedQuery<Employee> query=em.createNamedQuery(Employee.findEmployeesBySecondNameAndSortedByFirstName, Employee.class);
		query.setParameter("secondName", secondName);
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Employee> findEmployeesBetweenDurationAndSortedByName(
			Date startDate, Date endDate) {
		TypedQuery<Employee> query=em.createNamedQuery(Employee.findEmployeesBetweenDurationAndSortedByName, Employee.class);
		query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Employee> findEmployeesAfterStartDate(Date startDate) {
		TypedQuery<Employee> query=em.createNamedQuery(Employee.findEmployeesAfterStartDate, Employee.class);
		query.setParameter("startDate", startDate);
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Employee> findEmployeesAfterEndDate(Date endDate) {
		TypedQuery<Employee> query=em.createNamedQuery(Employee.findEmployeesAfterEndDate, Employee.class);
		query.setParameter("endDate", endDate);
		return query.getResultList();
	}
	
}
