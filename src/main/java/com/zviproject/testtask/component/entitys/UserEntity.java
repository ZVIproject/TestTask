package com.zviproject.testtask.component.entitys;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Entity
@Table(name = "user")
@NamedQueries({
		@NamedQuery(name = UserEntity.QUERY_NAME_FOR_GET_ALL, query = "SELECT ue FROM UserEntity ue LEFT JOIN FETCH ue.roleName") })
public class UserEntity {
	public static final String QUERY_NAME_FOR_GET_ALL = "UserEntity.getAll";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private Integer name;

	@Column(name = "password")
	private Integer password;

	@Column(name = "is_active")
	private Boolean isActive;

	@ManyToMany
	@JoinTable(name = "connect_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<String> roleName = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getName() {
		return name;
	}

	public void setName(Integer name) {
		this.name = name;
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

	public Set<String> getRoleName() {
		return roleName;
	}

	public void setRoleName(Set<String> roleName) {
		this.roleName = roleName;
	}

}
