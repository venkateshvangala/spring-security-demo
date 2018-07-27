package com.getset.leaveservice.controller;

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

import com.getset.leaveservice.dto.SiteDTO;
import com.getset.leaveservice.entity.Organization;
import com.getset.leaveservice.entity.OrganizationSite;
import com.getset.leaveservice.service.OrganizationService;
import com.getset.leaveservice.service.SiteService;

@RestController
@RequestMapping("/sites")
public class SiteController {

	@Autowired
	private SiteService siteService;
	
	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/fetch_org_sites/{orgId}")
	public List<OrganizationSite> fetchAllOrganizations(@PathVariable long orgId) {
		return siteService.fetchAllSitesByOrganization(orgId);
	}

	@PostMapping("/add_site")
	public OrganizationSite addSite(@RequestBody SiteDTO siteDTO) {
		Organization organization = organizationService.fetchUserByOrganization(siteDTO.getOrgId());
		OrganizationSite organizationSite = modelMapper.map(siteDTO, OrganizationSite.class);
		organizationSite.setOrganization(organization);
		System.out.println(organization.getName());
		return siteService.addSite(organizationSite);
	}

	@PutMapping("/edit_site/{siteId}")
	public OrganizationSite updateSite(@RequestBody SiteDTO siteDTO, @PathVariable long siteId) {
		Organization organization = organizationService.fetchUserByOrganization(siteDTO.getOrgId());
		OrganizationSite organizationSite = modelMapper.map(siteDTO, siteService.findById(siteId).getClass());
		organizationSite.setOrganization(organization);
		System.out.println(organization.getName());
		return siteService.addSite(organizationSite);
	}
}
