package org.crm.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.crm.dao.model.InventoryCurrentItemDao;
import org.crm.entities.InventoryCurrentItem;
import org.springframework.stereotype.Repository;

@Repository("inventoryCurrentItemDao")
@Transactional
public class InventoryCurrentItemDaoImpl extends
		AbstractGenericDaoImpl<Integer, InventoryCurrentItem> implements
		InventoryCurrentItemDao {

	public InventoryCurrentItemDaoImpl() {
		super(InventoryCurrentItem.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<InventoryCurrentItem> findInventoryCurrentItemsByDepartmentId(
			Integer departmentId) {
		TypedQuery<InventoryCurrentItem> query = em.createNamedQuery(
				InventoryCurrentItem.findInventoryCurrentItemsByDepartmentId,
				InventoryCurrentItem.class);
		query.setParameter("departmentId", departmentId);
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public InventoryCurrentItem findInventoryCurrentItemByDepartmentIdAndProductId(
			Integer departmentId, Integer productId) {
		TypedQuery<InventoryCurrentItem> query = em
				.createNamedQuery(
						InventoryCurrentItem.findInventoryCurrentItemByDepartmentIdAndProductId,
						InventoryCurrentItem.class);
		query.setParameter("departmentId", departmentId);
		query.setParameter("productId", productId);
		return query.getSingleResult();
	}

}
