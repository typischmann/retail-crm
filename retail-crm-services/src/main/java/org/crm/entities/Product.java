package org.crm.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="product")
@NamedQueries({
		@NamedQuery(name="findProductById", query="select p from Product p where p.productid = :productid"),
		@NamedQuery(name="findProductByName", query="select p from Product p where p.productname = :productName")
})
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7858115141962844413L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_seq")
	@SequenceGenerator(name="product_seq", sequenceName="product_productid_seq",allocationSize=100)
	@Column(name="productid")
	private Long productid;
	
	@Column(name="productname")
	private String productname;
	
	@Column(name="productgroupcode")
	private String productgroupcode;
	
	@Column(name="productgroupname")
	private String productgroupname;
	
	@Column(name="instockflag")
	private String instockflag;
	
	@Column(name="fullprice")
	private float fullprice;

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductgroupcode() {
		return productgroupcode;
	}

	public void setProductgroupcode(String productgroupcode) {
		this.productgroupcode = productgroupcode;
	}

	public String getProductgroupname() {
		return productgroupname;
	}

	public void setProductgroupname(String productgroupname) {
		this.productgroupname = productgroupname;
	}

	public String getInstockflag() {
		return instockflag;
	}

	public void setInstockflag(String instockflag) {
		this.instockflag = instockflag;
	}

	public float getFullprice() {
		return fullprice;
	}

	public void setFullprice(float fullprice) {
		this.fullprice = fullprice;
	}		
	

}
