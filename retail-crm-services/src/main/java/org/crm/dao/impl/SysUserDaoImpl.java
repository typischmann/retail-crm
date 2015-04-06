package org.crm.dao.impl;

import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.crm.dao.model.SysUserDao;
import org.crm.entities.SysUser;
import org.springframework.stereotype.Repository;

@Repository("sysUserDao")
@Transactional
public class SysUserDaoImpl extends AbstractGenericDaoImpl<Integer, SysUser>
		implements SysUserDao {

	public SysUserDaoImpl() {
		super(SysUser.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean authenticateUserByUserNameAndUserPassword(String userName,
			String unencryptedPassword) {
		StoredProcedureQuery query = em.createNamedStoredProcedureQuery(SysUser.authenticateUserByUserNameAndUserPassword);
		query.setParameter("sys_user_name", userName);
		query.setParameter("sys_user_password", unencryptedPassword);
		query.execute();
		return (Boolean) query.getSingleResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SysUser findSysUserByUserName(String userName) {
		TypedQuery<SysUser> query = em.createNamedQuery(SysUser.findSysUserByUserName, SysUser.class);
		query.setParameter("userName", userName);
		return query.getSingleResult();
	}

}
