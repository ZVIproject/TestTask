package com.zviproject.testtask.component.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

	private static final String SQL_DELETE_ROLES_BY_ID = "DELETE FROM `user` WHERE id  IN(:rolesId)";

	private static final String SQL_GET_ROLE_BY_NAME = "FROM RoleEntity role WHERE name=:roleName";

	private static final String SQL_UPDATE_ROLE_BY_ID = "UPDATE RoleEntity role SET name = :roleName WHERE id=:roleId";

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Delete roles from DB
	 * 
	 * @param roleId
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
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
	@Transactional(rollbackFor = Exception.class)
	public List<RoleEntity> getRoles() {
		return sessionFactory.openSession().getNamedQuery("RoleEntity.getAllRoles").list();
	}

	/**
	 * Update role in DB
	 * 
	 * @param roleEntity
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(Integer roleId, RoleEntity roleEntity) {
		sessionFactory.getCurrentSession().createQuery(SQL_UPDATE_ROLE_BY_ID)
				.setParameter("roleName", roleEntity.getName()).setParameter("roleId", roleEntity.getId())
				.executeUpdate();
	}

	/**
	 * Create role in DB
	 * 
	 * @param roleEntity
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void create(RoleEntity roleEntity) {

		sessionFactory.openSession().save(roleEntity);
	}

	/**
	 * Find role in the DB by name
	 * 
	 * @param name
	 */
	@Override
	public RoleEntity findByName(String roleName) {
		return (RoleEntity) sessionFactory.openSession().createQuery(SQL_GET_ROLE_BY_NAME)
				.setParameter("roleName", roleName).uniqueResult();
	}
}
