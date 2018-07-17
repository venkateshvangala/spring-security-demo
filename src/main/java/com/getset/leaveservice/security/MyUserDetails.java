package com.getset.leaveservice.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.getset.leaveservice.entity.User;
import com.getset.leaveservice.repository.UserRepository;

@Service
public class MyUserDetails implements UserDetailsService {
	
	static final List<GrantedAuthority> AUTHORITIES = new ArrayList();

	static {
		AUTHORITIES.add(new SimpleGrantedAuthority("USER"));
	}
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		final User user = userRepository.findByUserName(userName);

		if (user == null) {
			throw new UsernameNotFoundException("User '" + userName + "' not found");
		}

		return org.springframework.security.core.userdetails.User//
				.withUsername(userName)//
				.password(user.getPassword())//
				.authorities(AUTHORITIES)//
				.accountExpired(false)//
				.accountLocked(false)//
				.credentialsExpired(false)//
				.disabled(false)//
				.build();
	}
}
