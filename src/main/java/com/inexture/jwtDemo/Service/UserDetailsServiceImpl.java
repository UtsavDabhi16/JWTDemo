package com.inexture.jwtDemo.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inexture.jwtDemo.Dao.UserRepository;
import com.inexture.jwtDemo.Model.CustomUserBean;
import com.inexture.jwtDemo.Model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username).orElseThrow(
				() -> new UsernameNotFoundException("User with " + "user name " + username + " not found"));
		return CustomUserBean.createInstance(user);
	}

}
