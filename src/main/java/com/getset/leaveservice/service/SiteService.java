package com.getset.leaveservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getset.leaveservice.entity.OrganizationSite;
import com.getset.leaveservice.repository.SiteRepository;

@Service
public class SiteService {

	@Autowired
	private SiteRepository siteRepository;

	public List<OrganizationSite> fetchAllSitesByOrganization(long orgId) {
		return siteRepository.fetchAllSitesByOrganization(orgId);
	}
	
	public OrganizationSite findById(long siteId) {
		return siteRepository.findById(siteId);
	}
	
	public OrganizationSite addSite(OrganizationSite organizationSite) {
		return siteRepository.save(organizationSite);
	}

}
