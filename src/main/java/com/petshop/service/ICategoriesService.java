package com.petshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petshop.entity.ProductCategory;
import com.petshop.entity.Products;
import com.petshop.entity.TypeOfCategory;

@Service
public interface ICategoriesService {
//	public List<TypeOfCategory> GetDataTypeOfCategoryByID(ItemType itemType);
	public List<ProductCategory> GetDataProductCategoryList(String type_id);
	public List<Products> GetDataProductByTypeID(String type_id);
	public List<Products> GetDataProductByTypeIDPaginate(String type_id,int start,int end);
	public List<Products> GetDataProductByTypeIDLimit9(String type_id);
	public List<String> GetDataProductCategory();
	public String getStringProductCategoryIDByName(String product_categ_name);
	public int UpdateProductCategoryID(String product_categ_id);
	public List<ProductCategory> GetAllDataProductCategory();
	public List<Products> GetDataProductByProductCategoryIDPaginate(String product_categ_id,int start,int totalProductpage);
	
}
