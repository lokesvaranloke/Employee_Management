package com.mini.loginBackend.dto;

public class SignupDTO {

	private String name;
	private String emailId;
	private String password;
	private String role;
	
	public SignupDTO() {
	}

	public SignupDTO(String name, String emailId, String password, String role) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "SignupDTO [name=" + name + ", emailId=" + emailId + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
