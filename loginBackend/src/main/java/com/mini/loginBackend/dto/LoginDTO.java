package com.mini.loginBackend.dto;

public class LoginDTO {

	private String emailId;
	private String password;
	private String role;
	
	public LoginDTO() {};
	
	public LoginDTO(String emailId, String password, String role) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.role=role;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginDTO [emailId=" + emailId + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
