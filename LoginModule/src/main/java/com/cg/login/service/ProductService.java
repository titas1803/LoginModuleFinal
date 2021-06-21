package com.cg.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.login.dao.IProductDao;
import com.cg.login.entity.Products;
import com.cg.login.exceptions.ProductNotFoundException;
import com.cg.login.util.ProductConstants;

@Service
public class ProductService implements IProductService{

	@Autowired
	private IProductDao productdao;
	
	@Override
	public List<Products> viewByName(String prodName) throws ProductNotFoundException {
		
		List<Products> lst=productdao.findByName(prodName.toLowerCase());
		if(lst.isEmpty())
			throw new ProductNotFoundException(ProductConstants.PRODUCT_NOT_FOUND);
		lst.sort((u1,u2)-> u1.getProdName().compareTo(u2.getProdName()));
		return lst;
	}

	@Override
	public Products viewById(int prodId) throws ProductNotFoundException {
		
		Optional<Products> optemp = productdao.findById(prodId);
		if (!optemp.isPresent()) {
			throw new ProductNotFoundException(ProductConstants.PRODUCT_NOT_FOUND);
		}
		return optemp.get();
	}

}
