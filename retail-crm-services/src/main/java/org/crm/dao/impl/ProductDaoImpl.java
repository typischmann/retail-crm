package org.crm.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.crm.dao.model.ProductDao;
import org.crm.entities.Product;
import org.springframework.stereotype.Repository;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager em;
		
	public Product getProductById(int productId) {
		TypedQuery<Product> query=em.createNamedQuery("findProductById", Product.class);
		query.setParameter("productid", productId);
		return query.getSingleResult();
	}

	public Product getProductByName(String productName) {
		TypedQuery<Product> query=em.createNamedQuery("findProductByName",Product.class);
		query.setParameter("productname", productName);
		return null;
	}

}
