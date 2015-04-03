package org.crm.dao.model;

import java.util.List;

import org.crm.entities.InventoryCurrentItem;


public interface InventoryCurrentItemDao extends AbstractGenericDao<Integer, InventoryCurrentItem> {
	
	public List<InventoryCurrentItem> findInventoryCurrentItemsByDepartmentId(Integer departmentId);
	
	public InventoryCurrentItem findInventoryCurrentItemByDepartmentIdAndProductId(Integer departmentId, Integer productId);

}
