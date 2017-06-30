package com.zviproject.testtask.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zviproject.testtask.component.entitys.RoleEntity;
import com.zviproject.testtask.services.RoleService;

/**
 * Controller for working with role CRUD
 * 
 * @author zviproject
 *
 */
@RestController
@RequestMapping(value = "/rest/testtask/v1/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	/**
	 * Delete roles from DB
	 * 
	 * @param roleId
	 */
	@RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
	public void deleteRoles(List<Integer> rolesId) {
		roleService.deleteRoles(rolesId);
	}

	/**
	 * Get roles from DB
	 * 
	 * @return Set<RoleEntity>
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<RoleEntity> getRoles() {
		return roleService.getRoles();
	}

	/**
	 * Update role in DB
	 * 
	 * @param roleEntity
	 */
	@RequestMapping(method = RequestMethod.PUT, produces = "application/json")
	public void updateRole(Integer roleId, RoleEntity roleEntity) {
		roleService.updateRole(roleId, roleEntity);
	}

	/**
	 * Create role in DB
	 * 
	 * @param roleEntity
	 */
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public void createRole(RoleEntity roleEntity) {
		roleService.createRole(roleEntity);
	}
}