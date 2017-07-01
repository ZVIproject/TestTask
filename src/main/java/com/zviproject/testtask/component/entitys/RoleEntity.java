package com.zviproject.testtask.component.entitys;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * User entity for working with role table in database
 * 
 * @author zviproject
 *
 */
@NamedQueries({
		@NamedQuery(name = RoleEntity.QUERY_NAME_FOR_GET_ALL, query = "SELECT re FROM RoleEntity re LEFT JOIN re.userName") })
@Entity
@Table(name = "role")
public class RoleEntity {

	public static final String QUERY_NAME_FOR_GET_ALL = "RoleEntity.getAllRoles";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy = "roleName", fetch = FetchType.EAGER)
	@JsonBackReference
	private Set<UserEntity> userName;

	public RoleEntity() {
	}

	/**
	 * Use for creating role with filled fields
	 * 
	 * @param name
	 */
	public RoleEntity(String name) {
		this.setName(name);
	}

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

	public Set<UserEntity> getUserName() {
		return userName;
	}

	public void setUserName(Set<UserEntity> userName) {
		this.userName = userName;
	}

}