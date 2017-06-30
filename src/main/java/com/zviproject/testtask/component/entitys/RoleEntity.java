package com.zviproject.testtask.component.entitys;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * User entity for working with role table in database
 * 
 * @author zviproject
 *
 */
@Entity
@Table(name = "role")
public class RoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@ManyToMany
	@JoinTable(name = "connect_user_role", 
		joinColumns = @JoinColumn(name = "role_id"), 
		inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<String> userName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getUserName() {
		return userName;
	}

	public void setUserName(Set<String> userName) {
		this.userName = userName;
	}

}