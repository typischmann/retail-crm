package org.crm.webservices.dto;

import org.crm.entities.adapter.TimeStampAdapter;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderInfoDto {
	
	private Integer Id;
	
	private Integer parentOrderId;
	
	private boolean paid;

	private String orderType;
	
	private String orderStatus;

	private boolean root;
    @XmlJavaTypeAdapter(value = TimeStampAdapter.class)
	private Timestamp createTs;
    @XmlJavaTypeAdapter(value = TimeStampAdapter.class)
	private Timestamp deltaTs;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getParentOrderId() {
		return parentOrderId;
	}

	public void setParentOrderId(Integer parentOrderId) {
		this.parentOrderId = parentOrderId;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public boolean isRoot() {
		return root;
	}

	public void setRoot(boolean root) {
		this.root = root;
	}

	public Timestamp getCreateTs() {
		return createTs;
	}

	public void setCreateTs(Timestamp createTs) {
		this.createTs = createTs;
	}

	public Timestamp getDeltaTs() {
		return deltaTs;
	}

	public void setDeltaTs(Timestamp deltaTs) {
		this.deltaTs = deltaTs;
	}	

}
