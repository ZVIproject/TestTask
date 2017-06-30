package com.zviproject.testtask.component.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zviproject.testtask.component.entitys.UserEntity;
import com.zviproject.testtask.component.interfaces.IUser;

/**
 * User CRUD operations with DB
 * 
 * @author zviproject
 *
 */
@Component
public class UserDao implements IUser {

	private static final String SQL_DELETE_USERS_BY_ID = "DELETE FROM `user` WHERE id  IN(:usersId);";

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Delete users from DB by users id
	 * 
	 * @param usersId
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteUsers(List<Integer> usersId) {

		sessionFactory.openSession().createQuery(SQL_DELETE_USERS_BY_ID).setParameter("usersId", usersId)
				.executeUpdate();
	}

	/**
	 * Get users from DB
	 * 
	 * @return Set<UserEntity>
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<UserEntity> getUsers() {

		return sessionFactory.openSession().getNamedQuery("UserEntity.getAll").list();
	}

	/**
	 * Update user in DB
	 * 
	 * @param userEntity
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateUser(Integer userId, UserEntity userEntity) {

		sessionFactory.openSession().update(userEntity);
	}

	/**
	 * Create user in DB
	 * 
	 * @param userEntity
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void createUser(UserEntity userEntity) {

		sessionFactory.openSession().save(userEntity);
	}

}
