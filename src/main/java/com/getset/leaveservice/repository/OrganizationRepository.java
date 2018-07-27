package com.getset.leaveservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getset.leaveservice.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

	List<Organization> findAll();
	
	Organization findById(long orgId);

}
