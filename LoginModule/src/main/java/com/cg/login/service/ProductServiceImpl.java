package com.cg.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.login.dao.IProductDao;
import com.cg.login.dto.ProdDto;
import com.cg.login.entity.Products;
import com.cg.login.exceptions.AlreadyExists;
import com.cg.login.exceptions.ProductNotFoundException;
import com.cg.login.util.ProductConstants;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private IProductDao productdao;
	
	@Override
	@Transactional
	public Integer addProduct(ProdDto prodto) throws AlreadyExists {
		Optional<Products> optprodbyId=productdao.findById(prodto.getProdId());
		if(optprodbyId.isPresent())
			throw new AlreadyExists(ProductConstants.PRODUCT_EXISTS);
		List<Products> optUserbyName=productdao.findByName(prodto.getProdName());
		if(optUserbyName.isEmpty())
			throw new AlreadyExists(ProductConstants.PRODUCT_EXISTS);
		Products prod = new Products();
		prod.setProdId(prodto.getProdId());
		prod.setProdName(prodto.getProdName().toLowerCase());
		prod.setProdCost(prodto.getProdCost());
		prod.setProdImg(prodto.getProdImg());
		Products persistedProd = productdao.save(prod);
		productdao.flush();
		return persistedProd.getProdId();
		
	}
	
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
