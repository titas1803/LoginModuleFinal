package com.cg.login.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import com.cg.login.util.LoginConstants;

/*
 * Created by Soumendu Maitra
 */
public class UserDto {

	private Integer userId;

	@NotBlank(message = LoginConstants.USERNAME_BLANK_MESSAGE)
	private String userName;

	@NotBlank(message = LoginConstants.CONTACTNO_VALIDATION_MESSAGE)
	@Pattern(regexp = "[0-9]{10}", message = LoginConstants.CONTACTNO_VALIDATION_MESSAGE)
	private String contactNo;

	@NotBlank(message = LoginConstants.EMAILID_BLANK_MESSAGE)
	@Email(message = "Invalid email")
	private String emailId;

	@Past(message = LoginConstants.DOB_VALIDATION_MESSAGE)
	private LocalDate userDob;

	@NotBlank(message = LoginConstants.ADDRESS_BLANK_MESSAGE)
	private String userAddress;

	@NotBlank(message = LoginConstants.LOCATION_BLANK_MESSAGE)
	private String location;

//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.@#$%^&+=_])(?=\\S+$).{8,20}$", message = LoginConstants.PASSWORD_PATTERN)
	@NotBlank(message = LoginConstants.PASSWORD_BLANK_MESSAGE)
	private String password;

	@NotBlank(message = LoginConstants.ROLE_BLANK_MESSAGE)
	@Pattern(regexp = "(user|admin)", message = LoginConstants.ROLE_VALIDATION_MESSAGE)
	private String role;

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

	public UserDto() {
		super();
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

	public LocalDate getUserDob() {
		return userDob;
	}

	public void setUserDob(LocalDate userDob) {
		this.userDob = userDob;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public UserDto(Integer userId, String userName, String contactNo, String emailId, LocalDate userDob,
			String userAddress, String location, String password, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.userDob = userDob;
		this.userAddress = userAddress;
		this.location = location;
		this.password = password;
		this.role = role;
	}

}
