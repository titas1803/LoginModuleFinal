package com.cg.login.service;

import java.util.List;

import com.cg.login.dto.UserDto;
import com.cg.login.entity.User;
import com.cg.login.exceptions.AlreadyExists;
import com.cg.login.exceptions.UserNotFoundException;

/*
 * Created by Soumendu Maitra
 */
public interface IUserService {

	public Integer createUser(UserDto userdto) throws AlreadyExists;
	public List<User> viewAllUser() throws UserNotFoundException;
	public List<User> viewByLocation(String location) throws UserNotFoundException;
	public List<User> viewByName(String userName) throws UserNotFoundException;
	
}
