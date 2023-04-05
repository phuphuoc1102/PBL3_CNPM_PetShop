package com.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dao.ItemTypeDao;
import com.petshop.dao.ProductsDao;
import com.petshop.dao.TypeOfCategoryDao;
import com.petshop.entity.ItemType;
import com.petshop.entity.Products;
import com.petshop.entity.TypeOfCategory;

@Service
public class TypeOfCategoryServiceImpl implements ITypeOfCategoryService{

	@Autowired
	private TypeOfCategoryDao typeOfCategoryDao;

	@Override
	public List<TypeOfCategory> GetDataTypeOfCategoryList(String item_id) {
		// TODO Auto-generated method stub
		return typeOfCategoryDao.GetDataTypeOfCategoryList(item_id);
	}

	@Override
	public List<TypeOfCategory> GetDataTypeOfCategory() {
		// TODO Auto-generated method stub
		return typeOfCategoryDao.GetDataTypeOfCategory();
	}
	@Override
	public List<TypeOfCategory> GetDataTypeOfCategory(String item_id) {
		// TODO Auto-generated method stub
		return typeOfCategoryDao.GetDataTypeOfCategory();
	}


	
	
	
	

	

}
