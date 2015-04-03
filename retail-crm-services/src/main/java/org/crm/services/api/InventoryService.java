package org.crm.services.api;

import org.crm.entities.InventoryChangeRecord;
import org.crm.entities.InventoryChangeRecord.ChangeStatus;

/**
 * 
 * @author JIBAO
 * 
 */
public interface InventoryService {

	/**
	 * 
	 * @param OrderItemId
	 * @param DepartmentId
	 * @param changeStatus
	 * @param amount
	 * @return
	 */
	public InventoryChangeRecord addSingleChangeRecord(Integer orderItemId,
			Integer departmentId, ChangeStatus changeStatus, Integer amount);
	

}
