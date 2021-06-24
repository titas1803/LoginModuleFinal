package com.cg.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login_products")
public class Products {

	@Id
	@Column(name = "prod_id")
	private Integer prodId;
	
	@Column(name="prod_name", length = 100)
	private String prodName;
	
	@Column(name = "prod_cost")
	private Double prodCost;
	
	@Column(name= "prod_imgurl", length=250)
	private String prodImg;

	public Products(Integer prodId, String prodName, Double prodCost, String prodImg) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodCost = prodCost;
		this.prodImg = prodImg;
	}

	public Products() {
		
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Double getProdCost() {
		return prodCost;
	}

	public void setProdCost(Double prodCost) {
		this.prodCost = prodCost;
	}

	public String getProdImg() {
		return prodImg;
	}

	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
	}
	
	
}
