package com.zviproject.testtask.component.entitys;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * User entity for working with user table in database
 * 
 * @author zviproject
 *
 */
@NamedQueries({
		@NamedQuery(name = UserEntity.QUERY_NAME_FOR_GET_ALL, query = "SELECT ue FROM UserEntity ue LEFT JOIN ue.roleName") })
@Entity
@Table(name = "user")
public class UserEntity {

	public static final String QUERY_NAME_FOR_GET_ALL = "UserEntity.getAllUsers";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private Integer password;

	@Column(name = "is_active")
	private Boolean isActive;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "connect_user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<RoleEntity> roleName = new HashSet<>();

	public UserEntity() {
	}

	/**
	 * Use for creating user with filled fields
	 * 
	 * @param name
	 * @param password
	 * @param isActive
	 */
	public UserEntity(String name, Integer password, Boolean isActive) {
		this.name = name;
		this.password = password;
		this.isActive = isActive;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Set<RoleEntity> getRoleName() {
		return roleName;
	}

	public void setRoleName(Set<RoleEntity> roleName) {
		this.roleName = roleName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
