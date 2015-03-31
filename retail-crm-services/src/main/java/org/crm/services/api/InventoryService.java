package org.crm.services.api;

import org.crm.entities.InventoryChangeRecord;
import org.crm.entities.InventoryChangeRecord.ChangeStatus;

/**
 * 
 * @author JIBAO
 * 
 */
public interface InventoryService {

	public InventoryChangeRecord addSingleChangeRecord(Integer OrderItemId,
			Integer DepartmentId, ChangeStatus changeStatus, Integer amount);
	

}
