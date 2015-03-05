package org.crm.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.crm.dao.model.OrderDao;
import org.crm.entities.Department;
import org.crm.entities.Employee;
import org.crm.entities.Order;
import org.springframework.stereotype.Repository;

@Repository("orderDao")
@Transactional
public class OrderDaoImpl extends AbstractGenericDaoImpl<Integer, Order> implements OrderDao {

	public OrderDaoImpl(){
		super(Order.class);
	}
	/**
	 * {@inheritDoc}
	 */
	public List<Order> findAllOrdersByDepartment(Department department) {
		TypedQuery<Order> query=em.createNamedQuery(Order.findAllOrdersByDepartment, Order.class);
		query.setParameter("department_id", department.getId());
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> findAllOrdersByEmployee(Employee employee) {
		TypedQuery<Order> query=em.createNamedQuery(Order.findAllOrdersByEmployee, Order.class);
		query.setParameter("employee_id", employee.getId());
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> findOrdersCreatedAfterStartDate(Timestamp startDate) {
		TypedQuery<Order> query = em.createNamedQuery(Order.findOrdersCreatedAfterStartDate, Order.class);
		query.setParameter("startDate", startDate);
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Order> findOrdersCreatedBetweenTimeInterval(
			Timestamp startDate, Timestamp endDate) {
		TypedQuery<Order> query = em.createNamedQuery(Order.findOrdersCreatedBetweenTimeInterval, Order.class);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		return query.getResultList();
	}

}
