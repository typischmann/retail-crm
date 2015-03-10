package org.crm.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product_price")
public class Price {
	@Id
	@Column(name="id")
	private Integer id;
	
	//Price Type	
	
	@ManyToOne
	private Product product;
	
	@Column(name="price_percent")
	private double pricePercent;
	
	//Currency 
	
	@Column(name="price")
	private double price;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="delta_ts")
	private Timestamp delta_ts; 

}
