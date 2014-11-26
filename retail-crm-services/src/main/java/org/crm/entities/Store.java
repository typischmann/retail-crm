package org.crm.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="store")
@NamedQueries({
	@NamedQuery(name=Store.findStoreById, query="select s from Store s where s.id = :id"),
	@NamedQuery(name=Store.findStoreByName, query="select s from Store s where s.name = :name")
})
public class Store {
	
	static final public String findStoreById="findStoreById";
	static final public String findStoreByName="findStoreByName";
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="store_seq")
	@SequenceGenerator(name="store_seq", sequenceName="store_id_seq")
	@Column(name="id")
	private Long id;
	
	@Column(name="address_id")
	private Integer address_id;

	@Column(name="name")
	private String name;
	
	@Column(name="name_en")
	private String name_en;

	@Column(name="manager_id")
	private Integer manager_id;
	
	@ManyToMany
	@JoinTable(name="store_warehouse",joinColumns={@JoinColumn(name="store_id", referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="warehouse_id", referencedColumnName="id")})
	private List<Warehouse> warehouses;
	
	@Column(name="delta_ts")
	private Timestamp delta_ts;

	public Long getId() {
		return id;
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

	public Integer getManager_id() {
		return manager_id;
	}

	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}

	public Timestamp getDelta_ts() {
		return delta_ts;
	}

	public void setDelta_ts(Timestamp delta_ts) {
		this.delta_ts = delta_ts;
	}
	
	public List<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}	

}
