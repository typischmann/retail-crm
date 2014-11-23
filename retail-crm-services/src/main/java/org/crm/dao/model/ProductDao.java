package org.crm.dao.model;

import org.crm.entities.Product;

public interface ProductDao {
	/**
	 * 
	 * @param productId
	 * @return
	 */
	public Product getProductById(int productId);
	
	
	/**
	 * 
	 * @param productName
	 * @return
	 */
	public Product getProductByName(String productName);
}
