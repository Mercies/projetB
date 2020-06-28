package com.learning.dto;

import javax.validation.constraints.NotNull;

public class UserDTO extends HistorizedDTO {

	private String email;
	

	private String password;

	private String firstName;

	private String lastName;

	private String token;

	private String tokenDate;

	private Boolean isOnline = false;

	private Boolean isOffline = false;

	private RoleDTO refRole;

	private LevelDTO level;
	

	private BranchDTO branch;
	

	private OrganizationDTO organization;


	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public UserDTO(Long id, String email, String password, String firstName, String lastName, String token,
			String tokenDate, Boolean isOnline, Boolean isOffline, RoleDTO refRole, LevelDTO level, BranchDTO branch,
			OrganizationDTO organization) {
		super(id);
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.token = token;
		this.tokenDate = tokenDate;
		this.isOnline = isOnline;
		this.isOffline = isOffline;
		this.refRole = refRole;
		this.level = level;
		this.branch = branch;
		this.organization = organization;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenDate() {
		return tokenDate;
	}

	public void setTokenDate(String tokenDate) {
		this.tokenDate = tokenDate;
	}

	public Boolean getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}

	public Boolean getIsOffline() {
		return isOffline;
	}

	public void setIsOffline(Boolean isOffline) {
		this.isOffline = isOffline;
	}

	public RoleDTO getRefRole() {
		return refRole;
	}

	public void setRefRole(RoleDTO refRole) {
		this.refRole = refRole;
	}

	public LevelDTO getLevel() {
		return level;
	}

	public void setLevel(LevelDTO level) {
		this.level = level;
	}

	public BranchDTO getBranch() {
		return branch;
	}

	public void setBranch(BranchDTO branch) {
		this.branch = branch;
	}

	public OrganizationDTO getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationDTO organization) {
		this.organization = organization;
	}
	

}
