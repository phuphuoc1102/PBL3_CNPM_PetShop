package com.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.entity.Customer;

@Service
public interface ICustomerService {
	@Autowired
	public List<Customer> GetDataCustomer();
	public int AddCustomer(Customer customer);
	public boolean CheckCustomer(Customer customer);
	public Customer GetCustomer(Customer customer);
}
