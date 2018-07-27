package com.getset.leaveservice.dto;

import java.util.ArrayList;
import java.util.List;

import com.getset.leaveservice.entity.Role;

public class UserRoleDTO {
	
	private int id;
	
	private List<Role> roles = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}
