package org.crm.services.impl;

import javax.transaction.Transactional;

import org.crm.dao.model.DepartmentDao;
import org.crm.dao.model.InventoryChangeRecordDao;
import org.crm.dao.model.InventoryCurrentItemDao;
import org.crm.dao.model.OrderItemDao;
import org.crm.entities.Department;
import org.crm.entities.InventoryChangeRecord;
import org.crm.entities.InventoryChangeRecord.ChangeStatus;
import org.crm.entities.InventoryCurrentItem;
import org.crm.entities.OrderItem;
import org.crm.services.api.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("inventoryService")
@Transactional
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryChangeRecordDao inventoryChangeRecordDao;

	@Autowired
	private InventoryCurrentItemDao inventoryCurrentItemDao;

	@Autowired
	private OrderItemDao orderItemDao;
	
	@Autowired
	private DepartmentDao departmentDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(rollbackOn = { Exception.class })
	public InventoryChangeRecord addSingleChangeRecord(Integer orderItemId,
			Integer departmentId, ChangeStatus changeStatus, Integer amount) {
		// TODO: Validate The current Inventory
		// TODO: It needs test for Lock and Cascade
		OrderItem orderItem = orderItemDao.find(orderItemId);
		InventoryCurrentItem inventoryCurrentItem = inventoryCurrentItemDao
				.findInventoryCurrentItemByDepartmentIdAndProductId(
						departmentId, orderItem.getProduct().getId());
		if (inventoryCurrentItem.getReservedAmount() + amount <= inventoryCurrentItem
				.getRealAmount()){
			InventoryChangeRecord inventoryChangeRecord = new InventoryChangeRecord();
			inventoryChangeRecord.setOrderItem(orderItem);
			
			Department department = departmentDao.find(departmentId);
			inventoryChangeRecord.setDepartment(department);
			
			inventoryChangeRecord.setChangeStatus(changeStatus);
			inventoryChangeRecord.setAmount(amount);
			
			inventoryChangeRecordDao.persist(inventoryChangeRecord);
			
			return inventoryChangeRecord;
		}else{
			return null;
		}
	}

}
