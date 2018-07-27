package com.getset.leaveservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getset.leaveservice.dto.OrganizationDTO;
import com.getset.leaveservice.dto.UserDTO;
import com.getset.leaveservice.entity.Organization;
import com.getset.leaveservice.entity.User;
import com.getset.leaveservice.entity.UserRole;
import com.getset.leaveservice.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/fetch_users")
	public List<UserDTO> getAllUsers() {
		List<User> users = userService.findAll();
		List<UserDTO> userDTO = new ArrayList<UserDTO>();
		for (User user : users) {
			UserDTO userDto = modelMapper.map(user, UserDTO.class);
			List<OrganizationDTO> orgDTOs = new ArrayList<>();
			for(Organization org: user.getOrganizations()) {
				orgDTOs.add(modelMapper.map(org, OrganizationDTO.class));
			}
			List<UserRole> userRoles = new ArrayList<>();
			for(UserRole role: user.getUserRoles()) {
				userRoles.add(modelMapper.map(role, UserRole.class));
			}
			userDto.setOrganizations(orgDTOs);
			userDto.setUserRoles(userRoles);
			userDTO.add(userDto);
		}
		
		
		
		
		return userDTO;
	}

	@PostMapping("/signin")
	public String login(@RequestBody UserDTO user) {
		return userService.signin(user.getUserName(), user.getPassword());
	}

	@PostMapping(path = "/signup")
	public User signup(@RequestBody UserDTO user) {
		return userService.signup(modelMapper.map(user, User.class));
	}

	@DeleteMapping(value = "/{username}")
	public String delete(@PathVariable String username) {
		userService.delete(username);
		return username;
	}

}
