package org.crm.services.api;

import org.crm.entities.SysUser;

public interface AuthenticateService {
	
	/**
	 * 
	 * @param userName
	 * @param unencryptedPassword
	 * @return
	 */
	public SysUser authenticateUserByUnencryptedUserPassword(String userName, String unencryptedPassword);

}
