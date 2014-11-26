package org.crm.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="warehouse")
@NamedQueries({
	@NamedQuery(name=Warehouse.findWarehouseById, query="select w from Warehouse w where w.id = :id"),
	@NamedQuery(name=Warehouse.findWarehouseByName, query="select w from Warehouse w where w.name = :name")
})
public class Warehouse {
	
	static public final String findWarehouseById="findWarehouseById";
	
	static public final String findWarehouseByName="findWarehouseByName";
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="warehouse_seq")
	@SequenceGenerator(name="warehouse_seq", sequenceName="warehouse_id_seq", allocationSize=100)
	@Column(name="id")
	private Long id;
	
	@Column(name="address_id")
	private Integer address_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="name_en")
	private String name_en;

	@ManyToMany(mappedBy="warehouses", fetch=FetchType.LAZY)
	private List<Store> stores;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="manager_employee_id")
	private Employee manager;
	
	
	@Column(name="delta_ts")
	private Timestamp delta_ts;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_en() {
		return name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}

	public Timestamp getDelta_ts() {
		return delta_ts;
	}

	public void setDelta_ts(Timestamp delta_ts) {
		this.delta_ts = delta_ts;
	}	
}
