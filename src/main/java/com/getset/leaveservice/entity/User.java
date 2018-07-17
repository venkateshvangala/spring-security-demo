package com.getset.leaveservice.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

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
	private byte isPwdExpired;

	@Column(name = "IS_USER_LOCKED")
	private byte isUserLocked;

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

	private byte status;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_ON")
	private Date updatedOn;

	@Column(name = "USER_NAME", unique = true, nullable = false)
	@Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
	private String userName;

	public User() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
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

	public byte getIsPwdExpired() {
		return this.isPwdExpired;
	}

	public void setIsPwdExpired(byte isPwdExpired) {
		this.isPwdExpired = isPwdExpired;
	}

	public byte getIsUserLocked() {
		return this.isUserLocked;
	}

	public void setIsUserLocked(byte isUserLocked) {
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

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
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

}