package com.zviproject.testtask.component.interfaces;

import java.util.List;

import com.zviproject.testtask.component.entitys.RoleEntity;

/**
 * Role interfase for CRUD actions
 * 
 * @author zviproject
 *
 */
public interface IRole {

	/**
	 * Delete roles from DB
	 * 
	 * @param roleId
	 */
	public void deleteRoles(List<Integer> rolesId);

	/**
	 * Get roles from DB
	 * 
	 * @return Set<RoleEntity>
	 */
	public List<RoleEntity> getRoles();

	/**
	 * Update role in DB
	 * 
	 * @param roleEntity
	 */
	public void update(Integer roleId, RoleEntity roleEntity);

	/**
	 * Create role in DB
	 * 
	 * @param roleEntity
	 */
	public void create(RoleEntity roleEntity);

	/**
	 * Find role in the DB by name
	 * 
	 * @param name
	 */
	public RoleEntity findByName(String roleName);

}