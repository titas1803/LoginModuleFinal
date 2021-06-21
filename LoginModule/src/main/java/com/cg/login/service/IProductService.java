package com.cg.login.service;

import java.util.List;

import com.cg.login.entity.Products;
import com.cg.login.exceptions.ProductNotFoundException;

public interface IProductService {

	public List<Products> viewByName(String prodName) throws ProductNotFoundException;
	public Products viewById(int prodId) throws ProductNotFoundException;
}
