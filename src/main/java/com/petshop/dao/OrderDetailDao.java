package com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.petshop.entity.MapperOrderDetail;
import com.petshop.entity.OrderDetail;

@Repository
public class OrderDetailDao extends BaseDao{
	@Autowired
	private ProductsDao productsDao;
	public int saveOrderDetail(OrderDetail orderdetail) {
		 String sql = "INSERT INTO order_detail VALUES (?, ?, ?, ?, ?)";
		    Object[] params = {
		    		orderdetail.getOrderId(),
		    		orderdetail.getProduct().getProduct_id(),
		    		orderdetail.getProduct_name(),
		    		orderdetail.getQuantity(),
		    		orderdetail.getPrice(),
		    };
		    try {
		    	int rowsInserted=_JdbcTemplate.update(sql,params);
		    	return rowsInserted;
		    }catch(Exception e) {
		    	System.out.println(e);
		       return 0;
		    }
	}
	public List<OrderDetail> findAll(String OrderID){
		List<OrderDetail> detailList=new ArrayList<>();
		try {
			String sql=" SELECT * FROM order_detail WHERE orderID='"+OrderID+"'";
			System.out.println(sql);
			detailList=_JdbcTemplate.query(sql, new MapperOrderDetail(productsDao));
			return detailList;
	
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
			public long TotalPriceProducts(List<OrderDetail> orderDetailList) {
			   long totalPriceQuantity=0;
			   for (OrderDetail item: orderDetailList) {
				   totalPriceQuantity+=item.getPrice()*item.getQuantity();
			   }
			   return totalPriceQuantity;
			}
	
}
