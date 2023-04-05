package com.petshop.controller;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.entity.Customer;
import com.petshop.entity.Order;
import com.petshop.service.CustomerService;
import com.petshop.service.OrderServiceImpl;

@Controller
public class CustomerController extends BaseController {
	@Autowired
	CustomerService customerService = new CustomerService();
	@Autowired
	private OrderServiceImpl orderService;
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView DangKy() {
		// mv.setViewName("index")
		mvShare.setViewName("customer/dangky");

		mvShare.addObject("customer", new Customer());
		return mvShare;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView CreateAcc(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam(name = "tenDangNhap", required = true) String tenDangNhap,
			@RequestParam(name = "matKhau", required = true) String matKhau,
			@RequestParam(name = "tenKhachHang", required = true) String tenKhachHang,
			@RequestParam(name = "email", required = true) String email,
			@RequestParam(name = "ngaySinh", required = true) String ngaySinh,
			@RequestParam(name = "gioiTinh", required = true) String gioiTinh,
			@RequestParam(name = "soDienThoai", required = true) String soDienThoai) {

		request.setAttribute("tenDangNhap", tenDangNhap);
		request.setAttribute("matKhau", matKhau);
		request.setAttribute("tenKhachHang", tenKhachHang);
		request.setAttribute("email", email);
		request.setAttribute("gioiTinh", gioiTinh);
		request.setAttribute("ngaySinh", ngaySinh);
		request.setAttribute("soDienThoai", soDienThoai);
		Customer customer = new Customer(tenDangNhap, matKhau, tenKhachHang, gioiTinh, Date.valueOf(ngaySinh),
				soDienThoai, email);
		Customer check = customerService.GetCustomer(customer);
		String baoLoi = "";
		if (check != null) {
			baoLoi = "Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác.<br/> ";
			request.setAttribute("baoLoi", baoLoi);
			mvShare.addObject("status", "Đăng ký tài khoản thất bại");
			mvShare.setViewName("customer/dangky");

		} else {
			int count = customerService.AddCustomer(customer);

			if (count > 0) {
				mvShare.addObject("status", "Đăng ký tài khoản thành công");
				mvShare.setViewName("customer/thanhcong");
			} else {
				mvShare.addObject("status", "Đăng ký tài khoản thất bại");
				mvShare.setViewName("customer/dangky");
			}

		}
		// mvShare.setViewName("customer/thanhcong");

		return mvShare;
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView DangNhap() {
		// mv.setViewName("index")
		mvShare.setViewName("customer/dangnhap");
		mvShare.addObject("customer", new Customer());
		return mvShare;
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView Login(HttpServletRequest request, HttpSession session,
			@RequestParam(name = "tenDangNhap", required = true) String tenDangNhap,
			@RequestParam(name = "matKhau", required = true) String matKhau) {
		request.setAttribute("tenDangNhap", tenDangNhap);
		request.setAttribute("matKhau", matKhau);
		Random rd = new Random();
		Customer customer = new Customer();
		customer.setTenDangNhap(tenDangNhap);
		customer.setMatKhau(matKhau);
		boolean check = customerService.CheckCustomer(customer);
		if (check == true) {
			mvShare.setViewName("redirect:trang-chu");
			session.setAttribute("LoginInfo", customerService.GetCustomer(customer));
		} else if (check == false) {
			mvShare.addObject("statusLogin", "Đăng nhập thất bại");
			mvShare.setViewName("redirect:dang-nhap");
		}

		return mvShare;
	}
	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String DangXuat(HttpServletRequest request,HttpSession session) {
		session.removeAttribute("LoginInfo");
		return "redirect:"+request.getHeader("Referer");
	}

	@RequestMapping(value="/thong-tin-tai-khoan",method = RequestMethod.GET)
	public ModelAndView Profile(HttpSession session) {
		Customer customer=(Customer) session.getAttribute("LoginInfo");
		if (customer!=null) {
		List<Order> orderList=orderService.findAllOrder(customer.getTenDangNhap());
		mvShare.addObject("orderList", orderList);
		mvShare.addObject("customer", customer);
		}
		mvShare.setViewName("customer/profile");
		return mvShare;
	}
	@RequestMapping(value="/thong-tin-tai-khoan",method = RequestMethod.POST)
	public void EditProfile(HttpSession session,@ModelAttribute("customer") Customer customer) {
		
	}
	@RequestMapping(value = "/chi-tiet-don-hang/{orderID}", method = RequestMethod.GET)
	public ModelAndView OrderDetail(@PathVariable String orderID) {
		mvShare.setViewName("customer/order_detail");
		Order order=new Order(orderService.findOrder(orderID));
		mvShare.addObject("totalPriceProducts", orderService.TotalPriceProducts(order.getOrderDetailList()));
		mvShare.addObject("Order",order);
		return mvShare;
	}
}
