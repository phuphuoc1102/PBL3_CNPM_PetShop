package com.petshop.entity;

import java.sql.Date;

public class Customer {
	private String tenDangNhap;
	private String matKhau; 
	private String tenKhachHang;
	private String gioiTinh;
	private Date ngaySinh;
	private String soDienThoai;
	private String email;
	
	public Customer() {
	}


	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public Customer( String tenDangNhap, String matKhau, String tenKhachHang, String gioiTinh,
			Date ngaySinh, String soDienThoai, String email) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.tenKhachHang = tenKhachHang;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
