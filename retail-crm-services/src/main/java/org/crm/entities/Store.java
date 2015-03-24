package org.crm.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="store")
@NamedQueries({
	@NamedQuery(name=Store.findStoreByManager, query = "select s from Store s where s.manager.id = :manager_id"),
	@NamedQuery(name=Store.findStoreByName, query="select s from Store s where s.name = :name")
})
public class Store implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2429319439160196666L;
	
	static final public String findStoreByName="findStoreByName";
	
	static final public String findStoreByManager="findStoreByManager";
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="store_seq")
	@SequenceGenerator(name="store_seq", sequenceName="store_id_seq")
	@Column(name="id")
	private Integer id;
	
	@Column(name="address_id")
	private Integer addressId;

	@Column(name="name")
	private String name;
	
	@Column(name="name_en")
	private String nameEn;
	
	@ManyToMany
	@JoinTable(name="store_warehouse",joinColumns={@JoinColumn(name="store_id", referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="warehouse_id", referencedColumnName="id")})
	private List<Warehouse> warehouses;
	
	@ManyToOne
	@JoinColumn(name="manager_employee_id")
	private Employee manager;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="deparment_id")
	private Department department;
	
	@Column(name="delta_ts")
	private Timestamp deltaTs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public Timestamp getDeltaTs() {
		return deltaTs;
	}

	public void setDeltaTs(Timestamp deltaTs) {
		this.deltaTs = deltaTs;
	}
	
	public List<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
