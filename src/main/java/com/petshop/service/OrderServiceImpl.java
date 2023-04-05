package com.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dao.OrderDao;
import com.petshop.dao.OrderDetailDao;
import com.petshop.entity.Order;
import com.petshop.entity.OrderDetail;

@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	OrderDao orderDao=new OrderDao();
	@Autowired
	OrderDetailDao orderDetailDao=new OrderDetailDao();
	
	@Override
	public int create(Order order) {
		return orderDao.create(order);
	}

	@Override
	public int AddOrder(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveOrderDetail(OrderDetail orderdetail) {
		return orderDetailDao.saveOrderDetail(orderdetail);
	}

	@Override
	public Order findOrder(String OrderID) {
		return orderDao.findOrder(OrderID);
	}

	@Override
	public List<OrderDetail> findAll(String OrderID) {
		return orderDetailDao.findAll(OrderID);
	}

	@Override
	public long TotalPriceProducts(List<OrderDetail> orderDetailList) {
		return orderDetailDao.TotalPriceProducts(orderDetailList);
	}

	@Override
	public List<Order> findAllOrder(String customerID) {
		// TODO Auto-generated method stub
		return orderDao.findAllOrder(customerID);
	}

}
