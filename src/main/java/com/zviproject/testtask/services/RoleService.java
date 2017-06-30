package com.zviproject.testtask.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zviproject.testtask.component.entitys.RoleEntity;
import com.zviproject.testtask.component.interfaces.IRole;

/**
 * Service for working with role CRUD operations
 * 
 * @author zviproject
 *
 */
@Service
public class RoleService {

	@Autowired
	private IRole iRole;

	/**
	 * Delete roles from DB
	 * 
	 * @param roleId
	 */
	public void deleteRoles(List<Integer> rolesId) {
		iRole.deleteRoles(rolesId);
	}

	/**
	 * Get roles from DB
	 * 
	 * @return Set<RoleEntity>
	 */
	public List<RoleEntity> getRoles() {
		return iRole.getRoles();
	}

	/**
	 * Update role in DB
	 * 
	 * @param roleEntity
	 */
	public void updateRole(Integer roleId, RoleEntity roleEntity) {
		iRole.updateRole(roleId, roleEntity);
	}

	/**
	 * Create role in DB
	 * 
	 * @param roleEntity
	 */
	public void createRole(RoleEntity roleEntity) {
		iRole.createRole(roleEntity);
	}
}
