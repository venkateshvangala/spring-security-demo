package com.getset.leaveservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getset.leaveservice.entity.Organization;
import com.getset.leaveservice.repository.OrganizationRepository;

@Service
public class OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	public List<Organization> fetchAllOrganizations() {
		return organizationRepository.findAll();
	}
	
	public Organization fetchUserByOrganization(long orgId) {
		return organizationRepository.findById(orgId);
	}
	
	public Organization addOrganization(Organization organization) {
		return organizationRepository.save(organization);
	}

}
