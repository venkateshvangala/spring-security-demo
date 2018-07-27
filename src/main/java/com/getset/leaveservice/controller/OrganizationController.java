package com.getset.leaveservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getset.leaveservice.dto.OrganizationDTO;
import com.getset.leaveservice.dto.UserDTO;
import com.getset.leaveservice.entity.Organization;
import com.getset.leaveservice.entity.OrganizationUser;
import com.getset.leaveservice.service.OrganizationService;

@RestController
@RequestMapping("/organization")
public class OrganizationController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private OrganizationService organizationService;
	
	@GetMapping("/fetch_all_organizations")
	public List<Organization> fetchAllOrganizations() {
		return organizationService.fetchAllOrganizations();
	}
	
	@GetMapping("/fetch_org_users/{orgId}")
	public List<UserDTO> fetchUserByOrganization(@PathVariable long orgId) {
		List<UserDTO> users = new ArrayList<>();
		List<OrganizationUser> organizationUsers = organizationService.fetchUserByOrganization(orgId).getOrganizationUsers();
		for(OrganizationUser organizationUser: organizationUsers) {
			users.add(modelMapper.map(organizationUser.getUser(), UserDTO.class));
		}
		return users;
	}
	
	@PostMapping("/add_organization")
	public Organization addOrganization(@RequestBody OrganizationDTO organizationDTO) {
		return organizationService.addOrganization(modelMapper.map(organizationDTO, Organization.class));
	}
	
	@PutMapping("/edit_organization/{orgId}")
	public Organization updateOrganization(@RequestBody OrganizationDTO organizationDTO, @PathVariable long orgId) {
		Organization organization = organizationService.fetchUserByOrganization(orgId);
		return organizationService.addOrganization(modelMapper.map(organizationDTO, organization.getClass()));
	}
}
       