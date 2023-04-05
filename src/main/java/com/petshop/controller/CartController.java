package com.petshop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.dao.CartDao;
import com.petshop.dto.CartDto;
import com.petshop.entity.Customer;
import com.petshop.entity.Order;
import com.petshop.entity.OrderDetail;
import com.petshop.service.CartServiceImpl;
import com.petshop.service.HomeServiceImpl;
import com.petshop.service.OrderServiceImpl;

@Controller
public class CartController extends BaseController {
	@Autowired
	private CartServiceImpl cartService;
	@Autowired
	private OrderServiceImpl orderService;

	@RequestMapping(value = "/san-pham/add-to-cart/{product_id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void AddCart(HttpServletRequest request, HttpSession session, @PathVariable String product_id) { //
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.AddCart(product_id, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantity", cartService.TotalQuantity(cart));
		session.setAttribute("totalPrice", cartService.TotalPrice(cart));
	}

	@RequestMapping(value = "/xoa-san-pham/{product_id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable String product_id) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("cart");
		cart = cartService.DeleteCard(product_id, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantity", cartService.TotalQuantity(cart));
		session.setAttribute("totalPrice", cartService.TotalPrice(cart));
	}

	@RequestMapping(value = "/EditCart/{product_id}/{quantity}", method = RequestMethod.GET)
	public String EditCard(HttpServletRequest request, HttpSession session, @PathVariable String product_id,
			@PathVariable int quantity) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("cart");
		cart = cartService.EditCard(product_id, quantity, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantity", cartService.TotalQuantity(cart));
		session.setAttribute("totalPrice", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping("/cart")
	public ModelAndView in() {
		mvShare.setViewName("customer/cart");
		Order order=new Order();
		mvShare.addObject("Shippingfee",order.getShippingFee());
		return mvShare;
	}

	@RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
	public ModelAndView checkout(HttpServletRequest request, HttpSession session) {
		mvShare.setViewName("customer/checkout");
		Order order = new Order();
		Customer customer = (Customer) session.getAttribute("LoginInfo");
		if (customer != null) {
			order.setRecipientName(customer.getTenKhachHang());
			order.setPhoneNumber(customer.getSoDienThoai());
			order.setEmail(customer.getEmail());
			
		}
		mvShare.addObject("order", order);

		return mvShare;
	}

	@RequestMapping(value = "/thanh-toan", method = RequestMethod.POST)
	public String checkout(HttpSession session, HttpServletRequest request, @ModelAttribute("order") Order order) {

		Random rd = new Random();
		
		String orderID = System.currentTimeMillis() + rd.nextInt(1000) + "";
		order.setOrderId(orderID);

		Customer customer = (Customer) session.getAttribute("LoginInfo");

		if (customer != null) {
			
			order.setCustomerId(customer.getTenDangNhap());
		}
		List<OrderDetail> listDetail=new ArrayList<>();
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("cart");
		if(cart!=null) {
		for (Entry<String, CartDto> item : cart.entrySet()) {
			OrderDetail orderDetail = new OrderDetail(orderID, item.getValue().getProduct(),
					item.getValue().getProduct().getProduct_name(), item.getValue().getQuantity(),
					item.getValue().getProduct().getPrice());
			listDetail.add(orderDetail);
		}
		}
		order.setOrderDetailList(listDetail);
		order.setTotalPrice();
		if (orderService.create(order) > 0) {
			for(OrderDetail item: listDetail) {
			orderService.saveOrderDetail(item);
			session.setAttribute("OrderID", orderID);
		}
		}
		return "redirect:thong-bao";
	}

	@RequestMapping(value = "/thong-bao", method = RequestMethod.GET)
	public ModelAndView Notify(HttpSession session) {
		mvShare.addObject("orderID", session.getAttribute("OrderID"));
		mvShare.setViewName("customer/thongbao");
		
		return mvShare;
	}
}
