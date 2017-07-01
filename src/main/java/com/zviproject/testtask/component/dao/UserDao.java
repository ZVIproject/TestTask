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

	private static final String SQL_DELETE_USERS_BY_ID = "DELETE FROM `user` WHERE id  IN(:usersId)";

	private static final String SQL_GET_USER_BY_NAME = "FROM UserEntity user WHERE name = :userName";

	private static final String SQL_UPDATE_USER_BY_ID = "UPDATE UserEntity user SET name = :userName, password = :userPassword, isActive = :userActive WHERE id=:userId";

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Delete users from DB by users id
	 * 
	 * @param usersId
	 */
	@Override
	@Transactional
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
	@Transactional
	public List<UserEntity> getUsers() {

		return sessionFactory.openSession().getNamedQuery("UserEntity.getAllUsers").list();
	}

	/**
	 * Update user in DB
	 * 
	 * @param userEntity
	 */
	@Override
	@Transactional
	public void update(Integer userId, UserEntity userEntity) {

		sessionFactory.getCurrentSession().createQuery(SQL_UPDATE_USER_BY_ID)
				.setParameter("userName", userEntity.getName()).setParameter("userPassword", userEntity.getPassword())
				.setParameter("userActive", userEntity.getIsActive()).setParameter("userId", userEntity.getId())
				.executeUpdate();
	}

	/**
	 * Create user in DB
	 * 
	 * @param userEntity
	 */
	@Override
	@Transactional
	public void create(UserEntity userEntity) {

		sessionFactory.openSession().save(userEntity);
	}

	/**
	 * Find user in the DB by name
	 * 
	 * @param name
	 */
	@Override
	@Transactional
	public UserEntity findByName(String userName) {

		return (UserEntity) sessionFactory.openSession().createQuery(SQL_GET_USER_BY_NAME)
				.setParameter("userName", userName).uniqueResult();
	}

}
