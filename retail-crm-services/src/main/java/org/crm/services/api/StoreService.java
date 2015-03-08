package org.crm.services.api;

import java.util.List;

import org.crm.entities.Department;
import org.crm.entities.Employee;
import org.crm.entities.Product;
import org.crm.entities.Store;
import org.crm.entities.Warehouse;

public interface StoreService {
	
	/**
	 * 
	 * @param store
	 */
	public void addSingleStore(Store store);
	
	/**
	 * 
	 * @param stores
	 */
	public void addStoreCollection(List<Store> stores);
	
	/**
	 * 
	 * @param store
	 * @param name
	 * @return
	 */
	public Store changeStoreName(Store store, String name);
	
	/**
	 * 
	 * @param store
	 * @param manager
	 * @return
	 */
	public Store changeStoreManager(Store store, Employee manager);
	
	/**
	 * 
	 * @param store
	 * @param department
	 * @return
	 */
	public Store changeStoreDepartment(Store store, Department department);
	
	/**
	 * 
	 * @param store
	 * @param warehouse
	 * @return
	 */
	public Store addWarehouseToStore(Store store, Warehouse warehouse);
	
	/**
	 * 
	 * @param store
	 * @param warehouse
	 * @return
	 */
	public Store removeWarehouseFromStore(Store store, Warehouse warehouse);
	
	/**
	 * 
	 * @param store
	 * @return
	 */
	public List<Product> getCurrentProductsByStore(Store store);
	
	/**
	 * 
	 * @param store
	 * @return
	 */
	public List<Product> getAllProductsByStore(Store store);
	
	/**
	 * 
	 * @param store
	 * @param product
	 * @return
	 */
	public Store addProductToStore(Store store, Product product);
	
	/**
	 * 
	 * @param store
	 * @param product
	 * @return
	 */
	public Store removeProductFromStore(Store store, Product product);
}
