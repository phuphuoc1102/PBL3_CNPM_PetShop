package com.petshop.controller.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.petshop.controller.BaseController;
import com.petshop.dto.PaginatesDto;
import com.petshop.entity.ProductCategory;
import com.petshop.entity.Products;
import com.petshop.entity.TypeOfCategory;
import com.petshop.service.CategoriesServiceImpl;
import com.petshop.service.HomeServiceImpl;
import com.petshop.service.IHomeService;
import com.petshop.service.ItemTypeServiceImpl;
import com.petshop.service.PaginatesServiceImpl;
import com.petshop.service.ProductService;
import com.petshop.service.TypeOfCategoryServiceImpl;

@Controller
public class AdminController extends BaseController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ItemTypeServiceImpl itemTypeService;
	@Autowired
	private CategoriesServiceImpl categoryService;
	@Autowired
	private PaginatesServiceImpl paginateService;
	@Autowired
	private TypeOfCategoryServiceImpl typeOfCategoryServiceImpl;
	@Autowired
	private HomeServiceImpl homeservice;

	@RequestMapping(value = "/home/admin", method = RequestMethod.GET)
	public ModelAndView Admin(HttpServletRequest request, HttpServletResponse response, Model model) {
		// mv.setViewName("index")
//		mvShare.addObject("dataProducts", productService.GetDataProduct());
		mvShare.addObject("productCategory", categoryService.GetDataProductCategory());
		mvShare.addObject("dataItemType", itemTypeService.GetDataItemType());
		mvShare.addObject("typeOfCategory", typeOfCategoryServiceImpl.GetDataTypeOfCategory());
//		mvShare.addObject("dog", typeOfCategoryServiceImpl.GetDataTypeOfCategoryByItemID("item01"));
//		mvShare.addObject("cat", typeOfCategoryServiceImpl.GetDataTypeOfCategoryByItemID("item02"));
		mvShare.addObject("dataProductCategory", categoryService.GetAllDataProductCategory());
		mvShare.setViewName("admin/index");
		return mvShare;
	}

//	@RequestMapping(value = "/home/danh-sach-san-pham", method = RequestMethod.GET)
//	public ModelAndView ListProduct(HttpServletRequest request, HttpServletResponse response, Model model,
//			@ModelAttribute("product") Products product) {
//		// mv.setViewName("index")
//		mvShare.addObject("dataProducts", productService.GetDataProduct());
//		mvShare.addObject("dataItemType", itemTypeService.GetDataItemType());
//		mvShare.addObject("productCategory", categoryService.GetDataProductCategory());
//		mvShare.setViewName("admin/crud/list_products");
//		return mvShare;
//	}
//	@RequestMapping(value = "/home/danh-sach-san-pham/{item_id}/{type_id}/{currentPage}")
//	public ModelAndView Product( HttpServletRequest request, HttpServletResponse response, Model model,
//		@ModelAttribute("product") Products product,@PathVariable String currentPage) {
//		mvShare.setViewName("admin/crud/list_products");
//		List<ProductCategory> categoryList=categoryService.GetDataProductCategory(type_id);
//		TypeOfCategory typeOfCategory=new TypeOfCategory();
//		typeOfCategory.setProductCategoryList(categoryList);
//		mvShare.addObject("category", typeOfCategory.getProductCategoryList());
//		
//		int totalProductPage = 12;
//		int TotalData = productService.GetDataProduct().size();
//		System.out.println(TotalData);
//		mvShare.addObject("dataProducts", productService.GetDataProduct());
//		mvShare.addObject("productCategory", categoryService.GetDataProductCategory());
//		PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,Integer.parseInt(currentPage));
//		mvShare.addObject("pageinfo", pageinfo);
//		mvShare.addObject("ProductPaginate",productService.GetDataProductPaginate(pageinfo.getStart(), totalProductPage));
//		return mvShare;
//	}
//	@RequestMapping(value = "/home/danh-sach-san-pham/{item_id}/{type_id}/{currentPage}")
//	public ModelAndView Product(HttpServletRequest request, HttpServletResponse response, Model model,
//		@ModelAttribute("product") Products product,@PathVariable String item_id,@PathVariable String type_id,@PathVariable String currentPage) {
//		mvShare.setViewName("admin/crud/list_products");
//		TypeOfCategory typeOfCategory=new TypeOfCategory(homeservice.GetDataTypeOfCategory(type_id));
//		mvShare.addObject("category", typeOfCategory.getProductCategoryList());
//		
//		int totalProductPage = 12;
//	//	int TotalData = categoryService.GetDataProductByTypeID(type_id).size();
//		int TotalData = typeOfCategory.getProductCategoryList().size();
//		System.out.println(TotalData);
//		PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,Integer.parseInt(currentPage));
//		mvShare.addObject("pageinfo", pageinfo);
//		mvShare.addObject("ProductPaginate",categoryService.GetDataProductByTypeIDPaginate(type_id, pageinfo.getStart(), totalProductPage));
//		return mvShare;
//	}
//	@RequestMapping(value = "/home/danh-sach-san-pham/the-loai/{product_cate_id}/{currentPage}")
//	public ModelAndView ProductByProductCateg(		@ModelAttribute("product") Products product,@PathVariable String product_cate_id, @PathVariable String currentPage) {
//		mvShare.setViewName("admin/crud/list_products");
//		//mvShare.addObject("category", typeOfCategory.getProductCategoryList());
//		mvShare.addObject("productCategory1", categoryService.GetDataProductCategory());
//
//		ProductCategory productCategory=new ProductCategory(homeservice.GetDataProductCategory(product_cate_id));
//		mvShare.addObject("productCategory", productCategory);
//		mvShare.addObject("dataProducts", productService.GetDataProduct());
//	//	mvShare.addObject("productCategory", categoryService.GetDataProductCategory());
//		int totalProductPage = 12;
//		int TotalData = productCategory.getProductList(productCategory).size();
//		System.out.println("here"+TotalData);
//		PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,Integer.parseInt(currentPage));
//		mvShare.addObject("pageinfo", pageinfo);
//		mvShare.addObject("ProductPaginate",categoryService.GetDataProductByProductCategoryIDPaginate(product_cate_id, pageinfo.getStart(), totalProductPage));
//		return mvShare;
//	}
	@RequestMapping(value = "/home/danh-sach-san-pham/{item_id}/{type_id}/{currentPage}")
	public ModelAndView Product(HttpServletRequest request, HttpServletResponse response, Model model,
		@ModelAttribute("product") Products product,@PathVariable String item_id,@PathVariable String type_id,@PathVariable String currentPage) {
		mvShare.setViewName("admin/crud/list_products");
		List<ProductCategory> categoryList=categoryService.GetDataProductCategoryList(type_id);
		TypeOfCategory typeOfCategory=new TypeOfCategory();
		typeOfCategory.setProductCategoryList(categoryList);
		mvShare.addObject("category", typeOfCategory.getProductCategoryList());
		
		int totalProductPage = 12;
	//	int TotalData = categoryService.GetDataProductByTypeID(type_id).size();
		int TotalData = categoryList.size();
		System.out.println(TotalData);
		PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,Integer.parseInt(currentPage));
		mvShare.addObject("pageinfo", pageinfo);
		mvShare.addObject("ProductPaginate",categoryService.GetDataProductByTypeIDPaginate(type_id, pageinfo.getStart(), totalProductPage));
		return mvShare;
	}
	@RequestMapping(value = "/home/chinh-sua-thong-tin-san-pham/{product_id}", method = RequestMethod.GET)
	public ModelAndView UpdateProductGET(HttpServletRequest request, HttpServletResponse response, Model model,
			@PathVariable String product_id) {
		// mv.setViewName("index")
		mvShare.addObject("dataProducts", productService.GetDataProduct());
		mvShare.addObject("productCategory", categoryService.GetDataProductCategory());
		// product_id = "d_pd001";
		Products product = productService.GetDataProductByProductID(product_id);
		mvShare.addObject("product", product);
		System.out.println("id=" + product.getProduct_id());
		mvShare.setViewName("admin/crud/update_products");
		return mvShare;
	}

	@RequestMapping(value = "/home/cap-nhat-san-pham/{product_id}", method = RequestMethod.POST)
	public String editsave(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("product") Products product, ModelMap model,
			@RequestParam(name = "product_categ_name", required = true) String product_categ_name) {
		request.setAttribute("product_categ_name", product_categ_name);
		System.out.println("catename=" + product_categ_name);
		String categoryID = categoriesServiceImpl.getStringProductCategoryIDByName(product_categ_name);
		System.out.println("pdid = " + product.getProduct_id());
		product.setProduct_categ_id(categoryID);
		productService.UpdateProduct(product);
		// mvShare.setViewName("redirect:/home/danh-sach-san-pham");

		// return mvShare;
		return "redirect:/home/danh-sach-san-pham";
	}

	@RequestMapping(value = "/home/xoa-san-pham/{product_id}", method = RequestMethod.GET)
	public String DeleteProduct(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("product") Products product, ModelMap model, @PathVariable String product_id) {
		product.setProduct_id(product_id);
		productService.DeleteProduct(product);
		mvShare.setViewName("redirect:/home/danh-sach-san-pham");

		return "redirect:/home/danh-sach-san-pham";
	}

	@RequestMapping(value = "/home/them-san-pham", method = RequestMethod.GET)
	public ModelAndView AddProduct(HttpServletRequest request, HttpServletResponse response, Model model) {
		// mv.setViewName("index")
		// mvShare.addObject("dataProducts", productService.GetDataProduct());
		mvShare.addObject("productCategory", categoryService.GetDataProductCategory());
		// mvShare.addObject("productCategories",
		// categoryService.GetDataProductCategory());
		mvShare.setViewName("admin\1"
				+ "/crud/list_products");
		return mvShare;
	}

	@RequestMapping(value = "/home/them-san-pham", method = RequestMethod.POST)
	public String CreateProduct(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("product") Products product, ModelMap model,
			@RequestParam(name = "product_categ_name", required = true) String product_categ_name) {
		request.setAttribute("product_categ_name", product_categ_name);
		// mvShare.addObject("dataProducts", productService.GetDataProduct());
		// mvShare.addObject("productCategory",
		// categoryService.GetDataProductCategory());
		String categoryID = categoriesServiceImpl.getStringProductCategoryIDByName(product_categ_name);
		System.out.println("pdid = " + product.getProduct_id());
		product.setProduct_categ_id(categoryID);
		productService.AddProduct(product);
		// mvShare.setViewName("customer/thanhcong");
		// mvShare.setViewName("redirect:/home/danh-sach-san-pham");
		// mvShare.

		// return mvShare;
		return "redirect:/home/danh-sach-san-pham";
	}
	
}
