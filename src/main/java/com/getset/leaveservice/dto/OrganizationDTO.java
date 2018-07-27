package com.getset.leaveservice.dto;

import java.util.ArrayList;
import java.util.List;

import com.getset.leaveservice.entity.OrganizationSite;
import com.getset.leaveservice.entity.OrganizationUser;

public class OrganizationDTO {

	private long id;
	private String name;
	private String secretKey;
	private String description;

	private List<OrganizationSite> organizationSites = new ArrayList<>();

	private List<OrganizationUser> organizationUsers = new ArrayList<>();

	public List<OrganizationUser> getOrganizationUsers() {
		return organizationUsers;
	}

	public void setOrganizationUsers(List<OrganizationUser> organizationUsers) {
		this.organizationUsers = organizationUsers;
	}

	public List<OrganizationSite> getOrganizationSites() {
		return organizationSites;
	}

	public void setOrganizationSites(List<OrganizationSite> organizationSites) {
		this.organizationSites = organizationSites;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
}
