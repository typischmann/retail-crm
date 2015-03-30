package org.crm.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.crm.dao.model.InventoryChangeRecordDao;
import org.crm.entities.InventoryChangeRecord;
import org.springframework.stereotype.Repository;
/**
 * The Dao class for accessing the change records of inventory in real time
 * @author JIBAO
 *
 */
//TODO: it needs a Test
@Repository("inventoryChangeRecordDao")
@Transactional
public class InventoryChangeRecordDaoImpl extends
		AbstractGenericDaoImpl<Integer, InventoryChangeRecord> implements
		InventoryChangeRecordDao {

	public InventoryChangeRecordDaoImpl() {
		super(InventoryChangeRecord.class);
	}

	@Override
	public List<InventoryChangeRecord> findRecordsByDepartmentIdAndTimeInterval(
			Integer departmentId, Date startDate, Date endDate) {
		TypedQuery<InventoryChangeRecord> query = em.createNamedQuery(
				InventoryChangeRecord.findRecordsByDepartmentIdAndTimeInterval,
				InventoryChangeRecord.class);
		query.setParameter("departmentId", departmentId);
		query.setParameter("startDate",startDate);
		query.setParameter("endDate",endDate);
		return query.getResultList();
	}

	@Override
	public List<InventoryChangeRecord> findRecordsByDepartmentIdAndOrderItemId(
			Integer departmentId, Integer orderItemId) {
		TypedQuery<InventoryChangeRecord> query = em.createNamedQuery(
				InventoryChangeRecord.findRecordsByDepartmentIdAndOrderItemId,
				InventoryChangeRecord.class);
		query.setParameter("departmentId", departmentId);
		query.setParameter("orderItemId",orderItemId);
		return query.getResultList();
	}
	
	

}
