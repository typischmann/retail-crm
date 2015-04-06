package org.crm.webservices.dto;

import java.sql.Date;


import org.crm.entities.SysUser.UserStatus;
import org.crm.entities.SysUser.UserType;

public class SysUserDto {

	private Integer id;

	private String userName;

	private String encryptedUserPassword;

	private Integer authorizationLevel;

	private UserStatus userStatus;

	private UserType userType;

	private Date startDate;

	private Date endDate;

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

}
