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
     * @param id unique id of ware house.
     * @return ware house object.
     */
	public Warehouse getWarehouseById(int id) {
		return this.find(id);
	}

    /**
     * @param manager manager charger of the ware house.
     * @return list of ware houses.
     */
	public List<Warehouse> getWarehouseByManager(Employee manager) {
		TypedQuery<Warehouse> query=em.createNamedQuery(Warehouse.findWarehouseByManager, Warehouse.class);
		query.setParameter("manager_id", manager.getId());
		return query.getResultList();
	}

    /**
     * @param name ware house name.
     * @return list of matching ware houses.
     */
	public Warehouse getWarehouseByName(String name) {
		TypedQuery<Warehouse> query=em.createNamedQuery(Warehouse.findWarehouseByName, Warehouse.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}

}
