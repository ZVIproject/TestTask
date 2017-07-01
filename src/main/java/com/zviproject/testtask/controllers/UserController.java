package com.zviproject.testtask.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zviproject.testtask.component.entitys.UserEntity;
import com.zviproject.testtask.services.UserService;

/**
 * Controller for working with user CRUD
 * 
 * @author zviproject
 *
 */
@RestController
@RequestMapping(value = "/rest/testtask/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Delete users from DB by users id
	 * 
	 * @param usersId
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteUsers(@RequestBody List<Integer> usersId) {
		userService.deleteUsers(usersId);
	}

	/**
	 * Get users from DB
	 * 
	 * @return Set<UserEntity>
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<UserEntity> getUsers() {
		return userService.getUsers();
	}

	/**
	 * Update user in DB
	 * 
	 * @param userEntity
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody UserEntity userEntity) {
		userService.update(userEntity);
	}

	/**
	 * Create user in DB
	 * 
	 * @param userEntity
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Integer> create(@RequestBody UserEntity userEntity) {
		Map<String, Integer> result = new HashMap<>();
		result.put("generated_user_id", userService.create(userEntity));
		return result;
	}

	/**
	 * Find user in the DB by name
	 * 
	 * @param name
	 */
	@RequestMapping(value = "/{user_name}", method = RequestMethod.GET)
	public UserEntity findByName(@PathVariable("user_name") String userName) {
		return userService.findByName(userName);
	}
}
