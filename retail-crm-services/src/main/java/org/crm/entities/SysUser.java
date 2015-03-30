package org.crm.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.crm.entities.adapter.SqlDateAdapter;
import org.crm.entities.adapter.TimeStampAdapter;

@Entity
@Table(name = "sys_users")
@NamedStoredProcedureQueries({ @NamedStoredProcedureQuery(name = SysUser.authenticateUserByUserNameAndUserPassword, procedureName = "AUTHENTICATE_SYS_USER_FUNC", parameters = {
		@StoredProcedureParameter(name = "sys_user_name", type = String.class),
		@StoredProcedureParameter(name = "sys_user_password", type = String.class) }) })
@NamedQueries({ @NamedQuery(name = SysUser.findSysUserByUserName, query = "select s from SysUser s where s.userName=:userName") })
@XmlRootElement
public class SysUser {

	public static final String authenticateUserByUserNameAndUserPassword = "authenticateUserByUserNameAndUserPassword";

	public static final String findSysUserByUserName = "findSysUserByUserName";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sys_user_seq")
	@SequenceGenerator(name = "sys_user_seq", sequenceName = "sys_users_id_seq")
	@Column(name = "id")
	private Integer id;

	@Column(name = "user_name", nullable = false, unique = true)
	private String userName;

	@Column(name = "encrypted_user_password", nullable = false)
	private String encryptedUserPassword;

	@Column(name = "authorization_level")
	private Integer authorizationLevel;

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "user_status")
	private UserStatus userStatus;

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "user_type")
	private UserType userType;

	@XmlJavaTypeAdapter(SqlDateAdapter.class)
	@Column(name = "start_date")
	private Date startDate;

	@XmlJavaTypeAdapter(SqlDateAdapter.class)
	@Column(name = "end_date")
	private Date endDate;

	@XmlJavaTypeAdapter(TimeStampAdapter.class)
	@Column(name = "delta_ts")
	private Date deltaTs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEncryptedUserPassword() {
		return encryptedUserPassword;
	}

	public void setEncryptedUserPassword(String encryptedUserPassword) {
		this.encryptedUserPassword = encryptedUserPassword;
	}

	public Integer getAuthorizationLevel() {
		return authorizationLevel;
	}

	public void setAuthorizationLevel(Integer authorizationLevel) {
		this.authorizationLevel = authorizationLevel;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
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

	public Date getDeltaTs() {
		return deltaTs;
	}

	public void setDeltaTs(Date deltaTs) {
		this.deltaTs = deltaTs;
	}

	public enum UserStatus {
		CREATED, VERIFIED, BLOCKED
	}

	public enum UserType {
		Personal_Customer, Organization_Customer, Employee, Supplier
	}
}
