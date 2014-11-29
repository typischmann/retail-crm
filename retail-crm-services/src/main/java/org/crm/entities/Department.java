package org.crm.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="department")
@NamedQueries({
	@NamedQuery(name=Department.findDepartmentById, query="select d from Department d where d.id=:id"),
	@NamedQuery(name=Department.findDepartmentsByName, query="select d from Department d where d.name=:name"),
	@NamedQuery(name=Department.findSubDepartmentsByParentId, query="select d from Department d where d.parent.id=:id")})
public class Department implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7074669646491706699L;
	
	static final public String findDepartmentById="findDepartmentById";
	static final public String findDepartmentsByName="findDepartmentsByName";
	static final public String findSubDepartmentsByParentId="findSubDepartmentsByParentId";
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="department_seq")
	@SequenceGenerator(name="department_seq", sequenceName="department_id_seq")
	@Column(name="id")
	private Integer id;

	@Column(name="name")
	private String name;
	
	@Column(name="name_en")
	private String name_en;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_department_id")
	private Department parent;
	
	@OneToMany(mappedBy="parent")
	private List<Department> subDepartments;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	public List<Department> getSubDepartments() {
		return subDepartments;
	}

	public void setSubDepartments(List<Department> subDepartments) {
		this.subDepartments = subDepartments;
	}	
}
