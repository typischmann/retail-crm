package org.crm.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.crm.dao.model.DepartmentDao;
import org.crm.entities.Department;
import org.springframework.stereotype.Repository;

@Repository("deparmentDao")
@Transactional
public class DepartmentDaoImpl extends AbstractGenericDaoImpl<Integer, Department> implements DepartmentDao {

	@PersistenceContext
	private EntityManager em;
	
	public Department findDepartmentById(Integer id) {
		TypedQuery<Department> query=em.createNamedQuery(Department.findDepartmentById, Department.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	public List<Department> findDepartmentsByName(String name) {
		TypedQuery<Department> query=em.createNamedQuery(Department.findDepartmentsByName, Department.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

	public List<Department> findSubDepartmentsByParentId(Integer id) {
		TypedQuery<Department> query=em.createNamedQuery(Department.findSubDepartmentsByParentId, Department.class);
		query.setParameter("id", id);
		return query.getResultList();
	}	

}
