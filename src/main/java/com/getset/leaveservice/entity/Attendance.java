package com.getset.leaveservice.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the attendance database table.
 * 
 */
@Entity
@NamedQuery(name = "Attendance.findAll", query = "SELECT a FROM Attendance a")
public class Attendance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_ON")
	private Date createdOn;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOG_IN")
	private Date logIn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOG_OUT")
	private Date logOut;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_ON")
	private Date updatedOn;
	
	@Column(name = "LOG_IN_LAT")
	private String logInLat;
	
	@Column(name = "LOG_IN_LAG")
	private String logInLag;
	
	@Column(name = "LOG_OUT_LAT")
	private String logOutLat;
	
	@Column(name = "LOG_OUT_LAG")
	private String logOutLag;

	public String getLogInLat() {
		return logInLat;
	}

	public void setLogInLat(String logInLat) {
		this.logInLat = logInLat;
	}

	public String getLogInLag() {
		return logInLag;
	}

	public void setLogInLag(String logInLag) {
		this.logInLag = logInLag;
	}

	public String getLogOutLat() {
		return logOutLat;
	}

	public void setLogOutLat(String logOutLat) {
		this.logOutLat = logOutLat;
	}

	public String getLogOutLag() {
		return logOutLag;
	}

	public void setLogOutLag(String logOutLag) {
		this.logOutLag = logOutLag;
	}

	public Attendance() { }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public Date getLogIn() {
		return this.logIn;
	}

	public void setLogIn(Date logIn) {
		this.logIn = logIn;
	}

	public Date getLogOut() {
		return this.logOut;
	}

	public void setLogOut(Date logOut) {
		this.logOut = logOut;
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

}