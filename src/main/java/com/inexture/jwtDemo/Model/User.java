package com.inexture.jwtDemo.Model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String userName;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
	
	public User() {
	}

	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Role> roles = new HashSet<>();

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password + ", roles="
				+ roles + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getEmail() {
		return email;
	}

	public User(Integer id, String userName, String email, String password, Set<Role> roles) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public User(String userName, String email, String password, Set<Role> roles) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}