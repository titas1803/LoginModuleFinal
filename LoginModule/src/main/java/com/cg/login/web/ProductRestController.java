package com.cg.login.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cg.login.entity.Products;
import com.cg.login.exceptions.LoginException;
import com.cg.login.exceptions.ProductNotFoundException;
import com.cg.login.service.ILoginService;
import com.cg.login.service.IProductService;
import com.cg.login.util.LoginConstants;

@RestController
public class ProductRestController {

	@Autowired
	private IProductService prodServ;
	@Autowired
	private ILoginService loginSer;
	

	@GetMapping("viewprodsbyname/{prodName}")
	public List<Products> viewbyName(@PathVariable("prodName") String prodName,
			@RequestHeader("token-id") String tokenId) throws LoginException, ProductNotFoundException {
		if (loginSer.verifyLogin(tokenId)) {
			return prodServ.viewByName(prodName);
		}
		throw new LoginException(LoginConstants.INVALID_LOGIN_TOKEN);
	}

	@GetMapping("viewprodbyid/{prodId}")
	public Products viewbyID(@PathVariable("prodId") Integer prodId, @RequestHeader("token-id") String tokenId)
			throws ProductNotFoundException, LoginException {
		if (loginSer.verifyLogin(tokenId)) {
			return prodServ.viewById(prodId);
		}
		throw new LoginException(LoginConstants.INVALID_LOGIN_TOKEN);
	}
}
