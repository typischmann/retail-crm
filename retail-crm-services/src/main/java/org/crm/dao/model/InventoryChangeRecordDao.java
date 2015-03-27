package org.crm.dao.model;

import java.sql.Date;
import java.util.List;

import org.crm.entities.InventoryChangeRecord;

public interface InventoryChangeRecordDao extends AbstractGenericDao<Integer, InventoryChangeRecord> {

	/**
	 * 
	 * @param departmentId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<InventoryChangeRecord> findRecordsByDepartmentIdAndTimeInterval(
			Integer departmentId, Date startDate, Date endDate);

	/**
	 * 
	 * @param departmentId
	 * @param orderItemId
	 * @return
	 */
	public List<InventoryChangeRecord> findRecordsByDepartmentIdAndOrderItemId(
			Integer departmentId, Integer orderItemId);

}
