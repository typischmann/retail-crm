package org.crm.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.crm.entities.adapter.TimeStampAdapter;
/**
 * This entity class provide a real-time inventory overview of a product in a department 
 * @author JIBAO
 *
 */
@Entity
@Table(name="inventory_current_items")
public class InventoryCurrentItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="inventory_current_item_seq")
	@SequenceGenerator(name="inventory_current_item_seq", sequenceName="inventory_current_items_id_seq")
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	private Department department;

	@Column(name="real_amount")
	private Integer realAmount;
	
	@Column(name = "reserved_amount")
	private Integer reservedAmount;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "inventory_change_record_id")
	private InventoryChangeRecord inventoryChangeRecord;

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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(Integer realAmount) {
		this.realAmount = realAmount;
	}

	public Integer getReservedAmount() {
		return reservedAmount;
	}

	public void setReservedAmount(Integer reservedAmount) {
		this.reservedAmount = reservedAmount;
	}

	/**
	 * Get the last change
	 * @return
	 */
	public InventoryChangeRecord getInventoryChangeRecord() {
		return inventoryChangeRecord;
	}

	public void setInventoryChangeRecord(InventoryChangeRecord inventoryChangeRecord) {
		this.inventoryChangeRecord = inventoryChangeRecord;
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
