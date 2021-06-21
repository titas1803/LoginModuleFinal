package com.cg.login.dto;

import javax.validation.constraints.NotBlank;

import com.cg.login.util.ProductConstants;

public class ProdDto {
	
	@NotBlank(message = ProductConstants.ID_NOT_NULL)
	private Integer prodId;
	
	@NotBlank(message = ProductConstants.NAME_NOT_NULL)
	private String prodName;
	
	@NotBlank(message = ProductConstants.COST_NOT_NULL)
	private Double prodCost;
	
	@NotBlank(message = ProductConstants.IMG_NOT_NULL)
	private String prodImg;

	public ProdDto() {
		super();
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
