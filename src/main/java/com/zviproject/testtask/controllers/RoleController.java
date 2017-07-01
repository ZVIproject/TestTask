package com.zviproject.testtask.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteRoles(List<Integer> rolesId) {
		roleService.deleteRoles(rolesId);
	}

	/**
	 * Get roles from DB
	 * 
	 * @return Set<RoleEntity>
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<RoleEntity> getRoles() {
		return roleService.getRoles();
	}

	/**
	 * Update role in DB
	 * 
	 * @param roleEntity
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public void update(RoleEntity roleEntity) {
		roleService.update(roleEntity);
	}

	/**
	 * Create role in DB
	 * 
	 * @param roleEntity
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Integer> create(RoleEntity roleEntity) {
		Map<String, Integer> result = new HashMap<>();
		result.put("generated_role_id", roleService.create(roleEntity));
		return result;
	}

	/**
	 * Find role in the DB by name
	 * 
	 * @param name
	 */
	@RequestMapping(value = "/{role_name}", method = RequestMethod.GET)
	public RoleEntity findByName(@PathVariable("role_name") String roleName) {
		return roleService.findByName(roleName);
	}
}