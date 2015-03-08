package org.crm.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
	
	
	@Column(name="product_internal_code")
	private String productInternalCode;
	
	@Embedded
	private ProductCategory productCategory;
	
	
	
	@Embeddable
	public class ProductCategory implements Serializable{
		@Column(name="id")
		private Integer id;
		
		@Column(name="name")
		private String name;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
						
		
	}

}
