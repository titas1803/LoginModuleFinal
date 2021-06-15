package com.cg.login.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cg.login.dto.LoginDto;
import com.cg.login.dto.LoginResponse;
import com.cg.login.dto.SuccessMessage;
import com.cg.login.entity.Login;
import com.cg.login.exceptions.LoginException;
import com.cg.login.exceptions.ValidateUserException;
import com.cg.login.service.ILoginService;
import com.cg.login.util.LoginConstants;

/*
 * Created By Titas Sarkar
 */
@RestController
public class LoginRestController {

	@Autowired
	private ILoginService service;
	
	Logger logger=LoggerFactory.getLogger(LoginRestController.class);
	
	/*
	 * Controller Method for Login
	 */
	@PostMapping("login")
	public LoginResponse doLoginController(@Valid @RequestBody LoginDto logindto, BindingResult br) throws LoginException, ValidateUserException
	{
		if(!service.getAuthMap().isEmpty())
			throw new LoginException(LoginConstants.ALREADY_LOGGED_IN);
		if(br.hasErrors())
			throw new ValidateUserException(br.getFieldErrors());
		Login login=service.doLogin(logindto.getUserId(), logindto.getPassword());
		LoginResponse response= new LoginResponse();
		response.setToken(service.generateToken(login));
		response.setUserName(login.getUser().getUserName());
		response.setRole(login.getRole());
		return response;
	}
	
	/*
	 * Controller method for logging out
	 */
	@GetMapping(value="logout")
	public SuccessMessage logout(@RequestHeader("token-id") String token, HttpServletRequest req) {
		service.getAuthMap().remove(token);
		return new SuccessMessage(LoginConstants.LOGGED_OUT);
	}

}
