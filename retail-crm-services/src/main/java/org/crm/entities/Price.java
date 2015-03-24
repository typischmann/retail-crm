package org.crm.entities;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_price")
public class Price {
	@Id
	@Column(name="id")
	private Integer id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="price_type_id",referencedColumnName="id")
	private PriceType priceType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_id",referencedColumnName="id")
	private Product product;
	
	@Column(name="price_percent")
	private BigDecimal pricePercent;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="currency_id",referencedColumnName="id")
	private Currency currency;
	
	@Column(name="price")
	private BigDecimal priceValue;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="delta_ts")
	private Timestamp deltaTs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PriceType getPriceType() {
		return priceType;
	}

	public void setPriceType(PriceType priceType) {
		this.priceType = priceType;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public BigDecimal getPricePercent() {
		return pricePercent;
	}

	public void setPricePercent(BigDecimal pricePercent) {
		this.pricePercent = pricePercent;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public BigDecimal getPriceValue() {
		return priceValue;
	}

	public void setPriceValue(BigDecimal priceValue) {
		this.priceValue = priceValue;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Timestamp getDeltaTs() {
		return deltaTs;
	}

	public void setDelta_ts(Timestamp deltaTs) {
		this.deltaTs = deltaTs;
	} 
	
	
	

}
