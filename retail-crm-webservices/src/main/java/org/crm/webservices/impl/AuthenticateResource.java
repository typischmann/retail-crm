package org.crm.webservices.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.crm.entities.SysUser;
import org.crm.services.api.AuthenticateService;
import org.crm.webservices.api.AuthenticateWebService;
import org.crm.webservices.dto.SysUserDto;
import org.crm.webservices.mapping.ExtendedDozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("_authenticate_resource")
public class AuthenticateResource implements AuthenticateWebService {
	
	@Autowired
	private AuthenticateService authenticateService;
	
	@Autowired
	private ExtendedDozerBeanMapper orderDataMapper;

	@GET
	@Path("UnencryptedPassword")
	@Override
	public SysUserDto authenticateUserByUnencryptedUserPassword(
			@QueryParam("userName")String userName, @QueryParam("unencryptedPassword")String unencryptedPassword) {
		SysUser sysUser = authenticateService.authenticateUserByUnencryptedUserPassword(userName, unencryptedPassword);
		SysUserDto sysUserDto = orderDataMapper.map(sysUser, SysUserDto.class);
		return sysUserDto;
	}
	

}
