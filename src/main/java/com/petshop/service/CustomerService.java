package com.petshop.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.entity.Customer;
import com.petshop.dao.CustomerDao;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> GetDataCustomer() {
		// TODO Auto-generated method stub
		return customerDao.GetDataCustomer();
	}

	@Override
	public int AddCustomer(Customer customer) {
		// TODO Auto-generated method

		customer.setMatKhau(BCrypt.hashpw(customer.getMatKhau(), BCrypt.gensalt(12)));

		return customerDao.AddCustomer(customer);
	}

	@Override
	public boolean CheckCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
			String pass = customer.getMatKhau();
			Customer res;
			res=customerDao.GetCustomer(customer);
			
			if(res != null) {
				if(BCrypt.checkpw(pass,res.getMatKhau())) {
					return true;
				}
				else
					return false;
			}
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Customer GetCustomer(Customer customer) {
		// TODO Auto-generated method


		return customerDao.GetCustomer(customer);
	}
	

}
