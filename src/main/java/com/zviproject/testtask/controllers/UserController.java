package com.zviproject.testtask.controllers;

import java.util.List;

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
	public void updateUser(Integer userId, @RequestBody UserEntity userEntity) {
		userService.update(0, userEntity);
	}

	/**
	 * Create user in DB
	 * 
	 * @param userEntity
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void createUser(@RequestBody UserEntity userEntity) {
		userService.create(userEntity);
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
