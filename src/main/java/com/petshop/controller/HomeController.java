package com.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.service.CategoriesServiceImpl;



@Controller
public class HomeController extends BaseController{

	@Autowired
	private CategoriesServiceImpl categoryService;
	@RequestMapping(value = { "/trang-chu", "/" })
	public ModelAndView Index() {
		mvShare.setViewName("customer/home");
		mvShare.addObject("dataProducts", productService.GetDataProduct());
		mvShare.addObject("productCategory", categoryService.GetDataProductCategory());

		return mvShare;
	}
}
