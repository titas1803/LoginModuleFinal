package com.cg.login.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Created By Titas Sarkar
 */
@Entity
@Table(name = "login_module_login")
public class Login{
	
	@Id
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name="login_password",length=125)
	private String password;
	
	@Column(name="login_role",length=25)
	private String role;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@MapsId
	private User user;
	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	} 

	public Login(Integer userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}


	public Login() {
		
	}
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
	
	
}
