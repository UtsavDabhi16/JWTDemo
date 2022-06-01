package com.inexture.jwtDemo.Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserBean implements UserDetails, Serializable {

	private Integer id;
	private String userName;
	private String email;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

	public CustomUserBean(Integer id, String userName, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public static CustomUserBean createInstance(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRoleName().name())).collect(Collectors.toList());
		return new CustomUserBean(user.getId(), user.getUserName(), user.getEmail(), user.getPassword(), authorities);
	}

	public Integer getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		System.out.println("User Name is :" + userName);
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

//	@Override
//	public boolean equals(Object rhs) {
//		if (rhs instanceof CustomUserBean) {
//			return userName.equals(((CustomUserBean) rhs).userName);
//		}
//		return false;
//	}

	@Override
	public int hashCode() {
		return userName.hashCode();
	}

}
