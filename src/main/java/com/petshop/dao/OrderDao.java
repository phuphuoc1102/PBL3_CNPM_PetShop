package com.petshop.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petshop.entity.MapperOrder;
import com.petshop.entity.MapperOrderDetail;
import com.petshop.entity.Order;
import com.petshop.entity.OrderDetail;
import com.petshop.entity.Order.OrderStatus;
import com.petshop.dao.OrderDetailDao;
@Repository
public class OrderDao extends BaseDao{
	@Autowired
	private OrderDetailDao orderDetailDao;
		public int create(Order order) {
			order.setOrderTime(LocalDateTime.now());
			order.setStatus(OrderStatus.PENDING);
			System.out.println(order.getStatus());
		    String sql = "INSERT INTO order_customer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
		    Object[] params = {
		        order.getOrderId(),
		        order.getCustomerId(),
		        order.getRecipientName(),
		        order.getPhoneNumber(),
		        order.getEmail(),
		        order.getAddress(),
		        order.getOrderTime(),
		        null,
		        null,
		        null,
		        order.getStatus().toString(),
		        order.getShippingFee(),
		        order.getTotalPrice()
		    };
		    try {
		    
		    int rowsInserted = _JdbcTemplate.update(sql, params);
		        return rowsInserted;
		    }
		    catch(Exception e) {
		    	System.out.println(e);
		    	return 0;
		    }
		}
		public Order findOrder(String OrderID) {
			Order order=new Order();
			try {
				String sql=" SELECT * FROM order_customer WHERE orderID='"+OrderID+"'";
				System.out.println(sql);
				order=_JdbcTemplate.queryForObject(sql, new MapperOrder(orderDetailDao));
				return order;
				
			}catch(Exception e){
				System.out.println(e);
				return null;
			}
		}
		public List<Order> findAllOrder(String customerID) {
			List<Order> orderList=new ArrayList<>();
			try {
				String sql=" SELECT * FROM order_customer WHERE customerID='"+customerID+"'";
				System.out.println(sql);
				orderList=_JdbcTemplate.query(sql, new MapperOrder(orderDetailDao));
				return orderList;
				
			}catch(Exception e){
				System.out.println(e);
				return null;
			}
		}
}


