package org.crm.dao.model;

import org.crm.entities.Product;

public interface ProductDao {
	
	/**
	 * 
	 * @param productName
	 * @return
	 */
	public Product getProductByName(String productName);
}
