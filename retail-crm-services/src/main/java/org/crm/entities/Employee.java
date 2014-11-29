package org.crm.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
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

	@Column(name="note")
	private String note;
	

}
