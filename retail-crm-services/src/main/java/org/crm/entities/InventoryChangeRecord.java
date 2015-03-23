package org.crm.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="Inventory_Change_Records")
@XmlRootElement
public class InventoryChangeRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_change_record_seq")
	@SequenceGenerator(name = "inventory_change_record_seq", sequenceName = "inventory_change_records_seq_id_seq")
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	private Department department;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_item_id")
	private OrderItem orderItem;
	
	@Column(name = "amount_value")
	private Integer amount;
	
	@Enumerated(value=EnumType.ORDINAL)
	@Column(name = "change_type")
	private ChangeType changeType;
	
	@Enumerated(value=EnumType.ORDINAL)
	@Column(name = "change_status")
	private ChangeStatus changeStatus;
	
	@Column(name="delta_ts")
	private Timestamp deltaTs;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public ChangeType getChangeType() {
		return changeType;
	}

	public void setChangeType(ChangeType changeType) {
		this.changeType = changeType;
	}

	public ChangeStatus getChangeStatus() {
		return changeStatus;
	}

	public void setChangeStatus(ChangeStatus changeStatus) {
		this.changeStatus = changeStatus;
	}

	public Timestamp getDeltaTs() {
		return deltaTs;
	}

	public void setDeltaTs(Timestamp deltaTs) {
		this.deltaTs = deltaTs;
	}

	public enum ChangeType{
		INCOME,OUTCOME
	}
	
	public enum ChangeStatus{
		BEGIN, FINISHED,CANCELLED
	}
}
