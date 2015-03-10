package org.crm.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SecondaryTables;
import javax.persistence.SecondaryTable;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "product")
@NamedQueries({ @NamedQuery(name = Product.findProductByName, query = "select p from Product p where p.productName = :productName") })
@XmlRootElement
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7858115141962844413L;

	public final static String findProductByName = "findProductByName";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@SequenceGenerator(name = "product_seq", sequenceName = "product_id_seq")
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String productName;

	@Column(name = "product_internal_code")
	private String productInternalCode;

	
	@ManyToOne
	@JoinColumn(name="product_category_id", referencedColumnName="id")
	private ProductCategory productCategory;
	
	
	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getProductName() {
		return productName;
	}




	public void setProductName(String productName) {
		this.productName = productName;
	}




	public String getProductInternalCode() {
		return productInternalCode;
	}




	public void setProductInternalCode(String productInternalCode) {
		this.productInternalCode = productInternalCode;
	}




	public ProductCategory getProductCategory() {
		return productCategory;
	}




	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

}


