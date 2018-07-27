package com.getset.leaveservice.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_ON")
	private Date createdOn;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "IS_PWD_EXPIRED")
	private boolean isPwdExpired;

	@Column(name = "IS_USER_LOCKED")
	private boolean isUserLocked;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_LOGIN_AT")
	private Date lastLoginAt;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_PASSWORD_CHANGED_AT")
	private Date lastPasswordChangedAt;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	private String password;

	private String phone;

	private boolean status;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_ON")
	private Date updatedOn;

	@Column(name = "USER_NAME")
	private String userName;

	// bi-directional many-to-many association to Organization
	@ManyToMany(mappedBy = "users")
	@JsonIgnore
	private List<Organization> organizations;

	// bi-directional many-to-one association to OrganizationUser
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<OrganizationUser> organizationUsers;

	// bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<UserRole> userRoles;

	public User() {
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

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public boolean getIsPwdExpired() {
		return this.isPwdExpired;
	}

	public void setIsPwdExpired(boolean isPwdExpired) {
		this.isPwdExpired = isPwdExpired;
	}

	public boolean getIsUserLocked() {
		return this.isUserLocked;
	}

	public void setIsUserLocked(boolean isUserLocked) {
		this.isUserLocked = isUserLocked;
	}

	public Date getLastLoginAt() {
		return this.lastLoginAt;
	}

	public void setLastLoginAt(Date lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getLastPasswordChangedAt() {
		return this.lastPasswordChangedAt;
	}

	public void setLastPasswordChangedAt(Date lastPasswordChangedAt) {
		this.lastPasswordChangedAt = lastPasswordChangedAt;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Organization> getOrganizations() {
		return this.organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	public List<OrganizationUser> getOrganizationUsers() {
		return this.organizationUsers;
	}

	public void setOrganizationUsers(List<OrganizationUser> organizationUsers) {
		this.organizationUsers = organizationUsers;
	}

	public OrganizationUser addOrganizationUser(OrganizationUser organizationUser) {
		getOrganizationUsers().add(organizationUser);
		organizationUser.setUser(this);

		return organizationUser;
	}

	public OrganizationUser removeOrganizationUser(OrganizationUser organizationUser) {
		getOrganizationUsers().remove(organizationUser);
		organizationUser.setUser(null);

		return organizationUser;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setUser(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setUser(null);

		return userRole;
	}

}