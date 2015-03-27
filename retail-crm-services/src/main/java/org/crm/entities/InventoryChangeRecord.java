package org.crm.entities;

import java.io.Serializable;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.crm.entities.adapter.TimeStampAdapter;

/**
 * This is the entity class for the changes of inventory
 * 
 * @author JIBAO
 * 
 */
@Entity
@Table(name = "Inventory_Change_Records")
@NamedQueries({ @NamedQuery(name = InventoryChangeRecord.findRecordsByDepartmentIdAndTimeInterval, query = "select i from InventoryChangeRecord i where i.department.id=:departmentId and i.createTs > :startDate and i.createTs <= :endDate"),
				@NamedQuery(name = InventoryChangeRecord.findRecordsByDepartmentIdAndOrderItemId, query = "select i from InventoryChangeRecord i where i.department.id=:departmentId and i.orderItem.id=:orderItemId")})
@XmlRootElement
public class InventoryChangeRecord implements Serializable {

	public static final String findRecordsByDepartmentIdAndTimeInterval = "findRecordsByDepartmentIdAndTimeInterval";

	public static final String findRecordsByDepartmentIdAndOrderItemId = "findRecordsByDepartmentIdAndOrderItemId";

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

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "change_type")
	private ChangeType changeType;

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "change_status")
	private ChangeStatus changeStatus;

	@XmlJavaTypeAdapter(value = TimeStampAdapter.class)
	@Column(name = "create_ts")
	private Timestamp createTs;

	@XmlJavaTypeAdapter(value = TimeStampAdapter.class)
	@Column(name = "delta_ts")
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

	public enum ChangeType {
		INCOME, OUTCOME
	}

	public enum ChangeStatus {
		BEGIN, RESERVED, FINISHED, CANCELLED
	}
}
