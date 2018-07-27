package com.getset.leaveservice.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the organization database table.
 * 
 */
@Entity
@NamedQuery(name="Organization.findAll", query="SELECT o FROM Organization o")
public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	private String description;

	private String logo;

	private String name;

	@Column(name="SECRET_KEY")
	private String secretKey;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_ON")
	private Date updatedOn;

	//bi-directional many-to-many association to User
	@ManyToMany
	@JsonIgnore
	@JoinTable(
		name="organization_user"
		, joinColumns={
			@JoinColumn(name="ORG_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="USER_ID")
			}
		)
	private List<User> users;

	//bi-directional many-to-one association to OrganizationSite
	@OneToMany(mappedBy="organization")
	@JsonIgnore
	private List<OrganizationSite> organizationSites;

	//bi-directional many-to-one association to OrganizationUser
	@OneToMany(mappedBy="organization")
	@JsonIgnore
	private List<OrganizationUser> organizationUsers;

	public Organization() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecretKey() {
		return this.secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<OrganizationSite> getOrganizationSites() {
		return this.organizationSites;
	}

	public void setOrganizationSites(List<OrganizationSite> organizationSites) {
		this.organizationSites = organizationSites;
	}

	public OrganizationSite addOrganizationSite(OrganizationSite organizationSite) {
		getOrganizationSites().add(organizationSite);
		organizationSite.setOrganization(this);

		return organizationSite;
	}

	public OrganizationSite removeOrganizationSite(OrganizationSite organizationSite) {
		getOrganizationSites().remove(organizationSite);
		organizationSite.setOrganization(null);

		return organizationSite;
	}

	public List<OrganizationUser> getOrganizationUsers() {
		return this.organizationUsers;
	}

	public void setOrganizationUsers(List<OrganizationUser> organizationUsers) {
		this.organizationUsers = organizationUsers;
	}

	public OrganizationUser addOrganizationUser(OrganizationUser organizationUser) {
		getOrganizationUsers().add(organizationUser);
		organizationUser.setOrganization(this);

		return organizationUser;
	}

	public OrganizationUser removeOrganizationUser(OrganizationUser organizationUser) {
		getOrganizationUsers().remove(organizationUser);
		organizationUser.setOrganization(null);

		return organizationUser;
	}

}