package com.getset.leaveservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getset.leaveservice.entity.OrganizationSite;

public interface SiteRepository extends JpaRepository<OrganizationSite, Integer> {

	List<OrganizationSite> findAll();
	
	OrganizationSite findById(long siteId);
	
	@org.springframework.data.jpa.repository.Query(value = "SELECT * FROM organization_sites WHERE ORG_ID = ?1", nativeQuery = true)
	List<OrganizationSite> fetchAllSitesByOrganization(long orgId);
}
