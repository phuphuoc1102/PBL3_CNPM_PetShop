package com.petshop.controller;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.petshop.dao.ProductsDao;
import com.petshop.entity.Customer;
import com.petshop.entity.Menus;
import com.petshop.entity.Products;
import com.petshop.service.CategoriesServiceImpl;
import com.petshop.service.HomeServiceImpl;
import com.petshop.service.ProductService;

@Controller
public class ProductController extends BaseController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoriesServiceImpl categoryService;
	@Autowired
	private HomeServiceImpl HomeService;

	@RequestMapping("/chi-tiet-san-pham/{product_id}")
	public ModelAndView Product(@PathVariable String product_id) {
		ModelAndView mv = new ModelAndView("customer/product_detail");
		List<Menus> menu = HomeService.GetDataMenu();
		mv.addObject("menu", menu);
		Products productdetail = (Products) productService.GetDataProductByProductID(product_id);
		mv.addObject("product", productdetail);

		String product_categ_id = productService.getStringProductCategory(product_id);

		mv.addObject("productByCategory", productService.GetDataProductByProductCategoryID(product_categ_id));
		return mv;
	}

}
