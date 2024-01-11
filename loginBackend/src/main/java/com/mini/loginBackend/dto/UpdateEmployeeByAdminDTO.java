package com.mini.loginBackend.dto;

public class UpdateEmployeeByAdminDTO {

	private String name;
	private String emailId;
	private String role;
	
	public UpdateEmployeeByAdminDTO() {}
	public UpdateEmployeeByAdminDTO(String name, String emailId, String role) {
		super();
		this.name = name;
		this.emailId = emailId;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UpdateEmployeeByAdminDTO [name=" + name + ", emailId=" + emailId + ", role=" + role + "]";
	}
	
	
}
