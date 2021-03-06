package com.learning.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User extends Historized {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7263208288016824088L;

	@Column(name = "email", length = 50)
	private String email;

	@Column(name = "password", length = 255)
	private String password;

	@Column(name = "first_name", length = 50)
	private String firstName;

	@Column(name = "last_name", length = 50)
	private String lastName;

	@Column(name = "phone", length = 20)
	private String phone;

	@Column(name = "TOKEN", length = 512)
	private String token;

	@Column(name = "TOKEN_DATE")
	private String tokenDate;

	@Column(name = "IS_ONLINE")
	@NotNull
	private Boolean isOnline = false;

	@Column(name = "IS_OFFLINE")
	@NotNull
	private Boolean isOffline = false;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REF_ROLE")
	private Role refRole;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "organization_id")
	private Organization organization;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "level_id")
	private Level level;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branch_id")
	private Branch branch;
	

	@Column(name = "is_locked", columnDefinition = "boolean default false", nullable = false)
	private boolean isLocked;

	@Column(name = "is_new", columnDefinition = "boolean default false", nullable = false)
	private boolean isNew;


	@JsonIgnore
	@Lob
	private String oldToken;

	@JsonIgnore
	private LocalDateTime tokenDateCreation;

	public User() {
		super();
		// TODO Auto-generated constructor stub
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

	public Role getRefRole() {
		return refRole;
	}

	public void setRefRole(Role refRole) {
		this.refRole = refRole;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}



	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public String getOldToken() {
		return oldToken;
	}

	public void setOldToken(String oldToken) {
		this.oldToken = oldToken;
	}

	public LocalDateTime getTokenDateCreation() {
		return tokenDateCreation;
	}

	public void setTokenDateCreation(LocalDateTime tokenDateCreation) {
		this.tokenDateCreation = tokenDateCreation;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", token=" + token + ", tokenDate=" + tokenDate + ", isOnline=" + isOnline + ", isOffline="
				+ isOffline + ", refRole=" + refRole + ", organization=" + organization + "]";
	}

}
