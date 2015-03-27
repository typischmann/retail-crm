package org.crm.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.crm.dao.model.WarehouseDao;
import org.crm.entities.Employee;
import org.crm.entities.Warehouse;
import org.springframework.stereotype.Repository;

@Repository("warehouseDao")
@Transactional
public class WarehouseDaoImpl extends AbstractGenericDaoImpl<Integer, Warehouse> implements WarehouseDao {

	public WarehouseDaoImpl(){
		super(Warehouse.class);
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Warehouse> findWarehouseByManager(Employee manager) {
		TypedQuery<Warehouse> query=em.createNamedQuery(Warehouse.findWarehouseByManagerId, Warehouse.class);
		query.setParameter("managerId", manager.getId());
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Warehouse findWarehouseByName(String name) {
		TypedQuery<Warehouse> query=em.createNamedQuery(Warehouse.findWarehouseByName, Warehouse.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Warehouse findWarehouseByDepartmentId(Integer departmentId) {
		TypedQuery<Warehouse> query = em.createNamedQuery(Warehouse.findWarehouseByDepartmentId, Warehouse.class);
		query.setParameter("departmentId", departmentId);
		return query.getSingleResult();
	}

}
