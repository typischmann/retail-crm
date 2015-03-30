package org.crm.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.crm.entities.adapter.TimeStampAdapter;
import org.crm.entities.converter.BooleanToYNConverter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Orders")
@NamedQueries(value = {
		@NamedQuery(name = Order.findAllOrdersByDepartment, query = "select o from Order o where o.responsibleDepartment.id=:departmentId"),
		@NamedQuery(name = Order.findAllOrdersByEmployee, query = "select o from Order o where o.responsibleEmployee.id=:employeeId"),
		@NamedQuery(name = Order.findOrdersCreatedAfterStartDate, query = "select o from Order o where o.createTs > :startDate"),
		@NamedQuery(name = Order.findOrdersCreatedBetweenTimeInterval, query = "select o from Order o where o.createTs > :startDate and o.createTs <= :endDate")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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
	private Department responsibleDepartment;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "responsible_employee_id")
	private Employee responsibleEmployee;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_order_id", nullable = true)
	private Order parentOrder;

	@Convert(converter = BooleanToYNConverter.class)
	@Column(name = "is_paid", nullable = false)
	private boolean paid;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "order_type")
	private OrderType orderType;

	@OneToMany(mappedBy = "parentOrder", cascade={CascadeType.ALL})
	private List<Order> subOrders;

	@Enumerated(value=EnumType.ORDINAL)
	@Column(name = "status")
	private OrderStatus orderStatus;

	@Convert(converter = BooleanToYNConverter.class)
	@Column(name = "is_root", nullable = false)
	private boolean root;

	@XmlJavaTypeAdapter(value = TimeStampAdapter.class)
	@Column(name = "create_ts", updatable=false)
	private Timestamp createTs;

	@XmlJavaTypeAdapter(value = TimeStampAdapter.class)
	@Column(name = "delta_ts")
	private Timestamp deltaTs;

	@OneToMany(mappedBy = "parentOrder", cascade={CascadeType.ALL})
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

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
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

	public boolean isRoot() {
		return root;
	}

	public void setRoot(boolean root) {
		this.root = root;
	}

	public enum OrderType {
		UNDEFINED, SALE, PURCHASE, TRANSPORT
	}

	public enum OrderStatus {
		UNDEFINED, CREATED, EXECUTED, CANCELLED
	}

}
