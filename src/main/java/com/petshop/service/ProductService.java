package com.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dao.ProductsDao;
import com.petshop.entity.Products;

@Service
public class ProductService implements IProductService{

	@Autowired
	private ProductsDao productsDao;
	
	public Products GetDataProductByProductID(String product_id) {
		
		return productsDao.GetDataProductByProductID(product_id);
	}
	public String getStringProductCategory(String product_id) {
		
		return productsDao.getStringProductCategory(product_id);
	}

	@Override
	public List<Products> GetDataProductByProductCategoryID(String product_categ_id) {
		return productsDao.GetDataProductByProductCategoryID(product_categ_id);
	}
	public List<Products> GetDataProduct(){
		return productsDao.GetDataProduct();
	}
	@Override
	public int UpdateProduct(Products products) {
		// TODO Auto-generated method stub
		return productsDao.UpdateProduct(products) ;
	}
	@Override
	public int DeleteProduct(Products products) {
		// TODO Auto-generated method stub
		return productsDao.DeleteProduct(products) ;
	}
	@Override
	public int AddProduct(Products products) {
		// TODO Auto-generated method stub
		return productsDao.AddProduct(products);
	}
	@Override
	public List<Products> GetDataProductPaginate(int start, int end) {
		// TODO Auto-generated method stub
		return productsDao.GetDataProductPaginate(start,end);
	}

}
