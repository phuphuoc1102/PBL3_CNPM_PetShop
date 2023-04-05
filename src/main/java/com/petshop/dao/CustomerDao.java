package com.petshop.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.petshop.entity.*;

@Repository
public class CustomerDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public List<Customer> GetDataCustomer(){
		List<Customer> list = new ArrayList<Customer>();
		String sql = "SELECT * FROM khachhang";
		list = _jdbcTemplate.query(sql, new MapperCustomer());
		return list;
	}
	public int AddCustomer(Customer customer)
	{
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO ");
		sql.append("khachhang ");
		sql.append("( ");
		sql.append("    tenDangNhap, ");
		sql.append("    matKhau, ");
		sql.append("    tenKhachHang, ");
		sql.append("    soDienThoai, ");
		sql.append("    gioiTinh, ");
		sql.append("    ngaySinh, ");
		sql.append("    email ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("(");
		sql.append("'"+customer.getTenDangNhap()+"',");
		sql.append("'"+customer.getMatKhau()+"',");
		sql.append("'"+customer.getTenKhachHang()+"',");
		sql.append("'"+customer.getSoDienThoai()+"',");
		sql.append("'"+customer.getGioiTinh()+"',");
		sql.append("'"+customer.getNgaySinh()+"',");
		sql.append("'"+customer.getEmail()+"'");
		sql.append(")");
		int insert = _jdbcTemplate.update(sql.toString());
		System.out.println("sql query:" + sql);
		return insert;
	}
	public Customer GetCustomer(Customer customer)
	{
		try {
			String  sql = "SELECT * FROM khachhang WHERE tendangnhap= '"+customer.getTenDangNhap()+"'";
			Customer res = _jdbcTemplate.queryForObject(sql,new MapperCustomer());
			return res;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}
