package com.inexture.jwtDemo.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "name")
	private Roles roleName;

	public Integer getId() {
		return id;
	}

	public Role() {
		
	}

	public Role(Integer id, Roles roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Roles getRoleName() {
		return roleName;
	}

	public void setRoleName(Roles roleName) {
		this.roleName = roleName;
	}
}