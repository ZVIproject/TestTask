package com.zviproject.testtask.component.interfaces;

import java.util.List;

import com.zviproject.testtask.component.entitys.UserEntity;

/**
 * User interfase for CRUD operations
 * 
 * @author zviproject
 *
 */
public interface IUser {

	/**
	 * Delete users from DB by users id
	 * 
	 * @param usersId
	 */
	public void deleteUsers(List<Integer> usersId);

	/**
	 * Get users from DB
	 * 
	 * @return Set<UserEntity>
	 */
	public List<UserEntity> getUsers();

	/**
	 * Update user in DB
	 * 
	 * @param userEntity
	 */
	public void update(Integer userId, UserEntity userEntity);

	/**
	 * Create user in DB
	 * 
	 * @param userEntity
	 */
	public void create(UserEntity userEntity);

	/**
	 * Find user in the DB by name
	 * 
	 * @param name
	 */
	public UserEntity findByName(String roleName);

}
