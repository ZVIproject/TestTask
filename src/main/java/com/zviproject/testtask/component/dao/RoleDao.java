package com.zviproject.testtask.component.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zviproject.testtask.component.entitys.RoleEntity;
import com.zviproject.testtask.component.interfaces.IRole;

/**
 * User CRUD operations with DB
 * 
 * @author zviproject
 *
 */
@Component
public class RoleDao implements IRole {

	private static final String SQL_DELETE_ROLES_BY_ID = "DELETE FROM `user` WHERE id  IN(:rolesId);";

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Delete roles from DB
	 * 
	 * @param roleId
	 */
	@Override
	public void deleteRoles(List<Integer> rolesId) {

		sessionFactory.openSession().createQuery(SQL_DELETE_ROLES_BY_ID).setParameter("rolesId", rolesId)
				.executeUpdate();
	}

	/**
	 * Get roles from DB
	 * 
	 * @return Set<RoleEntity>
	 */
	@Override
	public List<RoleEntity> getRoles() {
		return sessionFactory.openSession().createQuery("FROM RoleEntity roleEntity").list();
	}

	/**
	 * Update role in DB
	 * 
	 * @param roleEntity
	 */
	@Override
	public void updateRole(Integer roleId, RoleEntity roleEntity) {
		sessionFactory.openSession().update(roleEntity);
	}

	/**
	 * Create role in DB
	 * 
	 * @param roleEntity
	 */
	@Override
	public void createRole(RoleEntity roleEntity) {

		sessionFactory.openSession().save(roleEntity);
	}
}
