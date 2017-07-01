package com.zviproject.testtask.component.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.zviproject.testtask.component.entitys.RoleEntity;
import com.zviproject.testtask.component.interfaces.IRole;
import com.zviproject.testtask.standalone.TestTaskApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = TestTaskApplication.class)
@WebAppConfiguration
@Transactional
@Rollback
public class RoleDaoIntegrationTest {

	private final String ROLE_NAME = "TestRoleName";

	@Autowired
	private IRole iRole;

	/**
	 * Create a test role in the DB for testing operations
	 */
	@Before
	public void addTestRoleToTheDB() {
		iRole.create(new RoleEntity(ROLE_NAME));
	}

	/**
	 * Create role in DB test
	 */
	@Test
	public void createRoleTest() {
		Integer sizeBeforeAdding = iRole.getRoles().size();

		iRole.create(new RoleEntity(ROLE_NAME));

		assertEquals(iRole.getRoles().size(), sizeBeforeAdding + 1);
	}

	/**
	 * Delete role from DB test
	 */
	@Test
	public void deleteRoleTest() {

		Integer sizeBeforeDeleting = iRole.getRoles().size();

		iRole.deleteRoles(Arrays.asList());

		assertEquals(iRole.getRoles().size(), sizeBeforeDeleting - 1);
	}

	/**
	 * Update role in DB test
	 */
	@Test
	public void updateRoleTest() {

	}

	/**
	 * Get users from DB test
	 */
	@Test
	public void getRoles() {
		assertNotEquals(iRole.getRoles().size(), 0);
	}

}
