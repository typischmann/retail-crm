package org.crm.dao.impl;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.crm.dao.model.ProductDao;
import org.crm.entities.Product;
import org.springframework.stereotype.Repository;

@Repository("productDao")
@Transactional
public class ProductDaoImpl extends AbstractGenericDaoImpl<Integer, Product>
		implements ProductDao {

	public ProductDaoImpl() {
		super(Product.class);
	}

	public Product getProductByName(String productName) {
		TypedQuery<Product> query = em.createNamedQuery(Product.findProductByName,
				Product.class);
		query.setParameter("productName", productName);
		return null;
	}

}
