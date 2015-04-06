package org.crm.dao.model;

import org.crm.entities.SysUser;

public interface SysUserDao extends AbstractGenericDao<Integer, SysUser> {
	
	/**
	 * 
	 * @param userName
	 * @param unencryptedPassword
	 * @return
	 */
	public Boolean authenticateUserByUserNameAndUserPassword(String userName, String unencryptedPassword);

	/**
	 * 
	 * @param userName
	 * @return
	 */
	public SysUser findSysUserByUserName(String userName);
}
