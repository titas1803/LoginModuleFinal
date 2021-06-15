package com.cg.login.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/*
 * Created by Soumendu Maitra
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "login_user")
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
	@SequenceGenerator(name = "seq1", sequenceName = "login_seq", allocationSize = 1)
	private Integer userId;

	@Column(name = "user_name", length = 25, nullable = false)
	private String userName;

	@Column(name = "contact_no", length = 10, unique = true)
	private String contactNo;

	@Column(name = "email_id", unique = true)
	private String emailId;

	@Column(name = "user_dob")
	private LocalDate userDob;

	@Column(name = "user_address")
	private String userAddress;

	@Column(name = "user_location")
	private String location;

	public Integer getUserId() {
		return userId;
	}

	public User() {
		super();
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDate getUserdob() {
		return userDob;
	}

	public void setUserdob(LocalDate userdob) {
		this.userDob = userdob;
	}

	public User(Integer userId, String userName, String contactNo, String emailId, LocalDate userDob,
			String userAddress, String location) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.userDob = userDob;
		this.userAddress = userAddress;
		this.location = location;
	}

	public String getUseraddress() {
		return userAddress;
	}

	public void setUseraddress(String useraddress) {
		this.userAddress = useraddress;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
