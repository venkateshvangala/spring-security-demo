package com.getset.leaveservice.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.getset.leaveservice.entity.User;
import com.getset.leaveservice.exception.CustomException;
import com.getset.leaveservice.repository.UserRepository;
import com.getset.leaveservice.security.JwtTokenProvider;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	public String signin(String username, String password) {
		try {
			System.out.println(username);
			System.out.println(password);
			return jwtTokenProvider.createToken(userRepository.findByUserName(username).getEmailId());
		} catch (AuthenticationException e) {
			throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	public User signup(User user) {
		if (!userRepository.existsByUserName(user.getUserName())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			jwtTokenProvider.createToken(user.getUserName());
			return user;
		} else {
			throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	public User updateUser(User user) {
		User userModel = userRepository.findByEmailId(user.getEmailId());
		userModel.setStatus(user.getStatus());
		return userRepository.save(userModel);
	}

	public void delete(String username) {
		userRepository.deleteByUserName(username);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User fetchLoggedInUser() {
		String emailId = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByEmailId(emailId);
		if (user == null) {
			throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
		}
		return user;
	}

	public User search(String username) {
		User user = userRepository.findByUserName(username);
		if (user == null) {
			throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
		}
		return user;
	}

	public User whoami(HttpServletRequest req) {
		return userRepository.findByUserName(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
	}

}