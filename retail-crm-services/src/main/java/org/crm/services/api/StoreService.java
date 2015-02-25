package org.crm.services.api;

import java.util.List;

import org.crm.entities.Department;
import org.crm.entities.Employee;
import org.crm.entities.Product;
import org.crm.entities.Store;
import org.crm.entities.Warehouse;

public interface StoreService {
	
	public void addSingleStore(Store store);
	
	public void addStoreCollection(List<Store> stores);
	
	public Store changeStoreName(Store store, String name);
	
	public Store changeStoreManager(Store store, Employee manager);
	
	public Store changeStoreDepartment(Store store, Department department);
	
	public Store addWarehouseToStore(Store store, Warehouse warehouse);
	
	public Store removeWarehouseFromStore(Store store, Warehouse warehouse);
	
	public List<Product> getCurrentProductsByStore(Store store);
	
	public List<Product> getAllProductsByStore(Store store);
	
	public Store addProductToStore(Store store, Product product);
	
	public Store removeProductFromStore(Store store, Product product);
}
