package org.crm.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="employee")
@NamedQueries({
	@NamedQuery(name=Employee.findAllEmployeesSortedByName,
				query="select e from Employee e order by  e.secondName ,e.firstName"),
	@NamedQuery(name=Employee.findEmployeesByFullName, 
				query="select e from Employee e where e.firstName=:firstName and e.secondName=:secondName"),
	@NamedQuery(name=Employee.findEmployeesBySecondNameAndSortedByFirstName, 
				query="select e from Employee e where e.secondName=:secondName order by e.firstName"),
	@NamedQuery(name=Employee.findEmployeesBetweenDurationAndSortedByName, 
				query="select e from Employee e where e.startDate >= :startDate and e.endDate <= :endDate order by e.secondName, e.firstName"),
	@NamedQuery(name=Employee.findEmployeesAfterStartDate, 
				query="select e from Employee e where e.startDate >= :startDate"),
	@NamedQuery(name=Employee.findEmployeesAfterEndDate, 
				query="select e from Employee e where e.endDate >= :endDate")
})
@XmlRootElement
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Employee implements Serializable{ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5673926095030652190L;
	
	public static final String findAllEmployeesSortedByName="getAllEmployeesSortedByName";
	public static final String findEmployeesByFullName="getEmployeesByFullName";
	public static final String findEmployeesBySecondNameAndSortedByFirstName="getEmployeesBySecondNameAndSortedByFirstName";
	public static final String findEmployeesBetweenDurationAndSortedByName="getEmployeesBetweenDurationAndSortedByName";
	public static final String findEmployeesAfterStartDate="getEmployeesAfterStartDate";
	public static final String findEmployeesAfterEndDate="getEmployeesAfterEndDate";
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_seq")
	@SequenceGenerator(name="employee_seq", sequenceName="employee_id_seq")
	@Column(name="id")
	private Integer id;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="second_name")
	private String secondName;

	@Column(name="start_date")
	private Date startDate;

	@Column(name="end_date")
	private Date endDate;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;

	@Column(name="note")
	private String note;
	
	@Column(name="delta_ts", columnDefinition="default current_timestamp")
	private Timestamp delta_ts;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Timestamp getDelta_ts() {
		return delta_ts;
	}

	public void setDelta_ts(Timestamp delta_ts) {
		this.delta_ts = delta_ts;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}	

}
