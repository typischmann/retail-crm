package org.crm.dao.model;

import org.crm.entities.Product;

/**
 * The Product DAO interface.
 */
public interface ProductDao {
	
	/**
	 * 
	 * @param productName the name of the production.
	 * @return Product object.
	 */
	public Product getProductByName(String productName);
}
