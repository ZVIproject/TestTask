package com.zviproject.testtask.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zviproject.testtask.component.entitys.UserEntity;
import com.zviproject.testtask.component.interfaces.IUser;

/**
 * Service for working with user CRUD operations
 * 
 * @author zviproject
 *
 */
@Service
public class UserService {

	@Autowired
	private IUser iUser;

	/**
	 * Delete users from DB by users id
	 * 
	 * @param usersId
	 */
	public void deleteUsers(List<Integer> usersId) {
		iUser.deleteUsers(usersId);
	}

	/**
	 * Get users from DB
	 * 
	 * @return Set<UserEntity>
	 */
	public List<UserEntity> getUsers() {
		return iUser.getUsers();
	}

	/**
	 * Update user in DB
	 * 
	 * @param userEntity
	 */
	public void update(UserEntity userEntity) {
		iUser.update(userEntity);
	}

	/**
	 * Create user in DB
	 * 
	 * @param userEntity
	 */
	public Integer create(UserEntity userEntity) {
		return iUser.create(userEntity);
	}

	/**
	 * Find user in the DB by name
	 * 
	 * @param name
	 */
	public UserEntity findByName(String userName) {
		return iUser.findByName(userName);
	}

}
