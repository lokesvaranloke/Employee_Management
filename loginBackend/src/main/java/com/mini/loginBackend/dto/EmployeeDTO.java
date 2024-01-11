package com.mini.loginBackend.dto;

public class EmployeeDTO {

	private Long id;
	private String name;
	private String emailId;
	private String password;
	private String role;
	
	public EmployeeDTO() {}
	
	public EmployeeDTO(Long id, String name, String emailId, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		return "EmployeeDTO [id=" + id + ", name=" + name + ", emailId=" + emailId + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
