package com.cg.login.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.login.dao.ILoginDao;
import com.cg.login.dao.IUserDao;
import com.cg.login.dto.UserDto;
import com.cg.login.entity.Login;
import com.cg.login.entity.User;
import com.cg.login.exceptions.AlreadyExists;
import com.cg.login.exceptions.UserNotFoundException;
import com.cg.login.util.LoginConstants;

/*
 * Created by Soumendu Maitra
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userdao;

	@Autowired
	private ILoginService loginSer;

	@Autowired
	private ILoginDao logindao;
	

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	
	/*
	 * Method to create new User account
	 */
	@Override
	@Transactional
	public Integer createUser(UserDto userdto) throws AlreadyExists {
		Optional<User> optUserbyCon=userdao.findByContact(userdto.getContactNo());
		if(optUserbyCon.isPresent())
			throw new AlreadyExists(LoginConstants.CONTACT_EXISTS);
		Optional<User> optUserbyEmail=userdao.findByEmail(userdto.getEmailId());
		if(optUserbyEmail.isPresent())
			throw new AlreadyExists(LoginConstants.EMAILID_EXISTS);
		User user = new User();
		user.setUserName(userdto.getUserName().toLowerCase());
		user.setContactNo(userdto.getContactNo());
		user.setEmailId(userdto.getEmailId());
		user.setUserdob(userdto.getUserDob());
		user.setUseraddress(userdto.getUserAddress());
		user.setLocation(userdto.getLocation().toLowerCase());
		User persistedUser = userdao.save(user);
		userdao.flush();
		Login login = new Login();
		login.setPassword(loginSer.encryptString(userdto.getPassword()));
		login.setRole(userdto.getRole());
		login.setUser(persistedUser);
		logindao.save(login);
		return persistedUser.getUserId();
	}

	public UserServiceImpl() {
		super();
	}

	public UserServiceImpl(ILoginService loginSer) {
		super();
		this.loginSer = loginSer;
	}

	/*
	 * Method to View all existing users details
	 */
	@Override
	public List<User> viewAllUser() throws UserNotFoundException {
		List<User> lst = userdao.findAll();
		if (lst.isEmpty()) {
			throw new UserNotFoundException(LoginConstants.NO_USER_FOUND);
		}
		lst.sort((u1, u2) -> u1.getUserName().compareTo(u2.getUserName()));
		return lst;
	}

	/*
	 * Method to view all users details of a specific location
	 */
	@Override
	public List<User> viewByLocation(String location) throws UserNotFoundException {
		List<User> lst=userdao.findByLocation(location.toLowerCase());
		if(lst.isEmpty())
			throw new UserNotFoundException(LoginConstants.NO_USER_FOUND);
		lst.sort((u1,u2)-> u1.getUserName().compareTo(u2.getUserName()));
		return lst;
	}

	/*
	 * method to view all users of a specific name
	 */
	@Override
	public List<User> viewByName(String userName) throws UserNotFoundException {
		List<User> lst=userdao.findByName(userName.toLowerCase());
		if(lst.isEmpty())
			throw new UserNotFoundException(LoginConstants.NO_USER_FOUND);
		lst.sort((u1,u2)-> u1.getUserName().compareTo(u2.getUserName()));
		return lst;
	}

}
