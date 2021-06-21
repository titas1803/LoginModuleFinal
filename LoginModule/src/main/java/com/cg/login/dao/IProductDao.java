package com.cg.login.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.login.entity.Products;

public interface IProductDao extends JpaRepository<Products, Integer> {
	
	@Query("from Products p where p.prodName like %:prodname%")
	public List<Products> findByName(@Param("prodname") String prodName);

}
