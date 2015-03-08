package org.crm.dao.model;

import java.sql.Timestamp;
import java.util.List;

import org.crm.entities.Department;
import org.crm.entities.Employee;
import org.crm.entities.Order;

/**
 * Order DAO interface.
 */
public interface OrderDao extends AbstractGenericDao<Integer, Order> {
    /**
     *
     * @param department department object.
     * @return all orders under this department, sorting by time? status?
     */
	public List<Order> findAllOrdersByDepartment(Department department);

    /**
     *
     * @param employee employee object.
     * @return all orders under this employee, sorting by time? status?
     */
	public List<Order> findAllOrdersByEmployee(Employee employee);

    /**
     *
     * @param startDate epoch time in milliseconds.
     * @return the list of all orders after start date.
     */
	public List<Order> findOrdersCreatedAfterStartDate(Timestamp startDate);

    /**
     *
     * @param startDate epoch time in milliseconds.
     * @param endDate epoch time in milliseconds.
     * @return the list of all orders between the start time and end time.
     */
	public List<Order> findOrdersCreatedBetweenTimeInterval(Timestamp startDate, Timestamp endDate);
	
}
