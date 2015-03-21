package org.crm.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.crm.entities.adapter.TimeStampAdapter;
import org.crm.entities.converter.BooleanToYNConverter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Orders")
@NamedQueries({
		@NamedQuery(name = Order.findAllOrdersByDepartment, query = "select o from Order o where o.responsibleDepartment.id=:department_id"),
		@NamedQuery(name = Order.findAllOrdersByEmployee, query = "select o from Order o where o.responsibleEmployee.id=:employee_id"),
		@NamedQuery(name = Order.findOrdersCreatedAfterStartDate, query = "select o from Order o where o.create_ts > :startDate"),
		@NamedQuery(name = Order.findOrdersCreatedBetweenTimeInterval, query = "select o from Order o where o.create_ts > :startDate and o.create_ts <= :endDate") })
@XmlRootElement
public class Order implements Serializable {

	public static final String findAllOrdersByDepartment = "findAllOrdersByDepartment";

	public static final String findAllOrdersByEmployee = "findAllOrdersByEmployee";

	public static final String findOrdersCreatedAfterStartDate = "findOrdersAfterStartDate";

	public static final String findOrdersCreatedBetweenTimeInterval = "findOrdersCreatedBetweenTimeInterval";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	@SequenceGenerator(name = "order_seq", sequenceName = "orders_id_seq")
	@Column(name = "id")
	private Integer Id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RESPONSIBLE_DEPARTMENT_ID")
	@JsonIgnore
	private Department responsibleDepartment;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "responsible_employee_id")
	@JsonIgnore
	private Employee responsibleEmployee;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_order_id", nullable = true)
	@JsonIgnore
	private Order parentOrder;

	@Convert(converter = BooleanToYNConverter.class)
	@Column(name = "is_paid", nullable = false)
	private boolean is_paid;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "order_type")
	private OrderType orderType;

	@OneToMany(mappedBy = "parentOrder", cascade={CascadeType.ALL})
	@JsonIgnore
	private List<Order> subOrders;

	@Enumerated(value=EnumType.ORDINAL)
	@Column(name = "status")
	private OrderStatus orderStatus;

	@Convert(converter = BooleanToYNConverter.class)
	@Column(name = "is_root", nullable = false)
	private boolean is_root;

	@XmlJavaTypeAdapter(value = TimeStampAdapter.class)
	@Column(name = "create_ts")
	private Timestamp create_ts;

	@XmlJavaTypeAdapter(value = TimeStampAdapter.class)
	@Column(name = "delta_ts")
	private Timestamp delta_ts;

	@OneToMany(mappedBy = "parentOrder", cascade={CascadeType.ALL})
	@JsonIgnore
	private List<OrderItem> orderItems;

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Department getResponsibleDepartment() {
		return responsibleDepartment;
	}

	public void setResponsibleDepartment(Department responsibleDepartment) {
		this.responsibleDepartment = responsibleDepartment;
	}

	public Employee getResponsibleEmployee() {
		return responsibleEmployee;
	}

	public void setResponsibleEmployee(Employee responsibleEmployee) {
		this.responsibleEmployee = responsibleEmployee;
	}

	public boolean isIs_paid() {
		return is_paid;
	}

	public void setIs_paid(boolean is_paid) {
		this.is_paid = is_paid;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Timestamp getCreate_ts() {
		return create_ts;
	}

	public void setCreate_ts(Timestamp create_ts) {
		this.create_ts = create_ts;
	}

	public Timestamp getDelta_ts() {
		return delta_ts;
	}

	public void setDelta_ts(Timestamp delta_ts) {
		this.delta_ts = delta_ts;
	}

	public Order getParentOrder() {
		return parentOrder;
	}

	public void setParentOrder(Order parentOrder) {
		this.parentOrder = parentOrder;
	}

	public List<Order> getSubOrders() {
		return subOrders;
	}

	public void setSubOrders(List<Order> subOrders) {
		this.subOrders = subOrders;
	}

	public boolean isIs_root() {
		return is_root;
	}

	public void setIs_root(boolean is_root) {
		this.is_root = is_root;
	}

	public enum OrderType {
		PURCHASE, SALE, TRANSPORT
	}

	public enum OrderStatus {
		CREATED, EXECUTED, CANCELLED
	}

}
