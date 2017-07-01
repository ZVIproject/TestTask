package com.zviproject.testtask.component.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.zviproject.testtask.component.entitys.UserEntity;
import com.zviproject.testtask.component.interfaces.IUser;
import com.zviproject.testtask.standalone.TestTaskApplication;

/**
 * Tests for UserDao class
 * 
 * @author zviproject
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = TestTaskApplication.class)
@WebAppConfiguration
@Transactional
public class UserDaoIntegrationTest {

	@Autowired
	private IUser iUser;

	private final String USER_NAME = "TestName";

	private final String USER_PASSWORD = "testPassword";

	private final Boolean USER_IS_ACTIVE = true;

	private Integer userId;

	/**
	 * Create a test user in the DB for testing operations
	 */
	@Before
	public void addTestUserToTheDB() {
		userId = iUser.create(new UserEntity(USER_NAME, USER_PASSWORD, USER_IS_ACTIVE));
	}

	/**
	 * Create user in DB test
	 */
	@Test
	public void createUserTest() {
		Integer sizeBeforeAdding = iUser.getUsers().size();

		iUser.create(new UserEntity(USER_NAME, USER_PASSWORD, USER_IS_ACTIVE));

		assertEquals(iUser.getUsers().size(), sizeBeforeAdding + 1);
	}

	/**
	 * Delete user from DB test
	 */
	@Test
	public void deleteUserTest() {

		Integer sizeBeforeDeleting = iUser.getUsers().size();

		iUser.deleteUsers(Arrays.asList(userId));

		assertEquals(iUser.getUsers().size(), sizeBeforeDeleting - 1);
	}

	/**
	 * Update user in DB test
	 */
	@Test
	public void updateUserTest() {

		UserEntity userEntityForUpdate = new UserEntity();
		userEntityForUpdate.setId(userId);
		userEntityForUpdate.setName("TestUpdateName");
		userEntityForUpdate.setPassword("TestUpdatePassword");
		userEntityForUpdate.setIsActive(true);

		iUser.update(userEntityForUpdate);

		assertEquals(iUser.findByName("TestUpdateName").getPassword(), userEntityForUpdate.getPassword());

	}

	/**
	 * Get users from DB test
	 */
	@Test
	public void getUsers() {
		assertNotEquals(iUser.getUsers().size(), 0);
	}

}
