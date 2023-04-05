package com.petshop.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.petshop.entity.Products;

@Service
public interface IProductService {
	public Products GetDataProductByProductID(String product_id);
	public String getStringProductCategory(String product_id);
	public List<Products> GetDataProductByProductCategoryID(String product_categ_id);
	public List<Products> GetDataProduct(); 
	public int UpdateProduct(Products products);
	public int DeleteProduct(Products products);
	public int AddProduct(Products products);
	public List<Products> GetDataProductPaginate(int start,int end);
}


