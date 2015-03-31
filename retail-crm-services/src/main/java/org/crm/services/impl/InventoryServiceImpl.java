package org.crm.services.impl;

import javax.transaction.Transactional;

import org.crm.dao.model.InventoryChangeRecordDao;
import org.crm.entities.InventoryChangeRecord;
import org.crm.entities.InventoryChangeRecord.ChangeStatus;
import org.crm.services.api.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("inventoryService")
@Transactional
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	private InventoryChangeRecordDao inventoryChangeRecordDao;
	
	@Override
	public InventoryChangeRecord addSingleChangeRecord(Integer OrderItemId,
			Integer DepartmentId, ChangeStatus changeStatus, Integer amount) {
		// TODO: Validate The current Inventory
		
		return null;
	}

}
