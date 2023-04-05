package com.petshop.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCustomer implements RowMapper<Customer> {

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();		
		customer.setTenDangNhap(rs.getString("tendangnhap"));
		customer.setMatKhau(rs.getString("matkhau"));
		customer.setTenKhachHang(rs.getString("tenkhachhang"));
		customer.setGioiTinh(rs.getString("gioitinh"));
		customer.setNgaySinh(rs.getDate("ngaysinh"));		
		customer.setSoDienThoai(rs.getString("sodienthoai"));
		customer.setEmail(rs.getString("email"));
		return customer;
	}

}
