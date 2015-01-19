package org.crm.dao.impl;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.crm.dao.model.StoreDao;
import org.crm.entities.Employee;
import org.crm.entities.Store;
import org.springframework.stereotype.Repository;

@Repository("storeDao")
@Transactional
public class StoreDaoImpl extends AbstractGenericDaoImpl<Integer, Store> implements StoreDao {

	/**
	 * {@inheritDoc}
	 */
	public Store findStoreById(Integer id) {
		return this.find(id);
	}

	/**
	 * {@inheritDoc}
	 */
	public Store findStoreByManager(Employee manager) {
		TypedQuery<Store> query=this.em.createNamedQuery(Store.findStoreByManager, Store.class);
		query.setParameter("manager_id", manager.getId());
		return query.getSingleResult();
	}

	/**
	 * {@inheritDoc}
	 */
	public Store findStoreByName(String name) {
		TypedQuery<Store> query=this.em.createNamedQuery(Store.findStoreByName, Store.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}
	
}
