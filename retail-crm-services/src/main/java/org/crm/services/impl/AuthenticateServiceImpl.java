package org.crm.services.impl;

import org.crm.dao.model.SysUserDao;
import org.crm.entities.SysUser;
import org.crm.services.api.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("authenticateService")
public class AuthenticateServiceImpl implements AuthenticateService {

	@Autowired
	private SysUserDao sysUserDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SysUser authenticateUserByUnencryptedUserPassword(String userName,
			String unencryptedPassword) {
		Boolean authenticated = sysUserDao
				.authenticateUserByUserNameAndUserPassword(userName,
						unencryptedPassword);
		if (authenticated) {
			return sysUserDao.findSysUserByUserName(userName);
		} else {
			return null;
		}
	}

}
