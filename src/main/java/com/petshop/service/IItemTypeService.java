package com.petshop.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.petshop.entity.Customer;
import com.petshop.entity.ItemType;
import com.petshop.entity.Products;

@Service
public interface IItemTypeService {
	public List<ItemType> GetDataItemType(); 
	
}
