package com.getset.leaveservice.dto;

public class AttendanceDTO {

	private String emailId;
	private String logIn;
	private String logOut;
	private String logInLat;
	private String logInLag;
	private String logOutLat;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getLogIn() {
		return logIn;
	}
	public void setLogIn(String logIn) {
		this.logIn = logIn;
	}
	public String getLogOut() {
		return logOut;
	}
	public void setLogOut(String logOut) {
		this.logOut = logOut;
	}
}
