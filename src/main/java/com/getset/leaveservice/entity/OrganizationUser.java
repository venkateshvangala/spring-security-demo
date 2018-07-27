package com.getset.leaveservice.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the organization_user database table.
 * 
 */
@Entity
@Table(name="organization_user")
@NamedQuery(name="OrganizationUser.findAll", query="SELECT o FROM OrganizationUser o")
public class OrganizationUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	//bi-directional many-to-one association to Organization
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="ORG_ID")
	private Organization organization;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JsonIgnore
	private User user;

	public OrganizationUser() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}