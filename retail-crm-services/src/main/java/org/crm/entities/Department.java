package org.crm.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="department_seq")
	@SequenceGenerator(name="department_seq", sequenceName="department_id_seq")
	@Column(name="id")
	private Long id;

	@Column(name="name")
	private String name;
	
	@Column(name="name_en")
	private String name_en;

	@ManyToOne(fetch=FetchType.LAZY)
	private Department parent;
	
	@OneToMany(mappedBy="parent")
	@JoinColumn(name="parent_department_id")
	private List<Department> subDepartments;

}
