package com.getset.leaveservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getset.leaveservice.dto.UserDataDTO;
import com.getset.leaveservice.dto.UserResponseDTO;
import com.getset.leaveservice.entity.User;
import com.getset.leaveservice.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/get_users")
	public List<User> getAllUsers() {
		return userService.findAll();
	}

	@PostMapping("/signin")
	public String login(@RequestBody UserDataDTO user) {
		return userService.signin(user.getUserName(), user.getPassword());
	}

	@PostMapping(path = "/signup")
	public User signup(@RequestBody UserDataDTO user) {
		return userService.signup(modelMapper.map(user, User.class));
	}

	@DeleteMapping(value = "/{username}")
	public String delete(@PathVariable String username) {
		userService.delete(username);
		return username;
	}

	@GetMapping(value = "/{username}")
	public UserResponseDTO search(@PathVariable String username) {
		return modelMapper.map(userService.search(username), UserResponseDTO.class);
	}

	@GetMapping(value = "/me")
	public UserResponseDTO whoami(HttpServletRequest req) {
		return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
	}
}
