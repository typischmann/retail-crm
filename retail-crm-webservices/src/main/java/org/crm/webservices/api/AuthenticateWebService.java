package org.crm.webservices.api;

import org.crm.webservices.dto.SysUserDto;

public interface AuthenticateWebService {
	
	public SysUserDto authenticateUserByUnencryptedUserPassword(String userName, String unencryptedPassword);

}
