package com.getset.leaveservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getset.leaveservice.dto.UserDTO;
import com.getset.leaveservice.entity.User;
import com.getset.leaveservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/fetch_user")
	public UserDTO fetchLoggedInUser() {
		User user = userService.fetchLoggedInUser();
		return modelMapper.map(user, UserDTO.class);
	}

	@PostMapping(path = "/update_user")
	public User updateUser(@RequestBody UserDTO userDto) {
		return userService.updateUser(modelMapper.map(userDto, User.class));
	}

}
