package com.boot.application.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.application.dto.CustomerDto;
import com.boot.application.entity.Customer;
import com.boot.application.entity.ProductItems;
import com.boot.application.service.ProductService;
import com.boot.application.service.Services;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private Services services;

	@Autowired
	private ProductService productService;

	//static Logger logger = Logger.getLogger(CustomerController.class);

	static final String LOGIN = "login";

	@RequestMapping("/home")
	public String homePage(Model model) {
		List<ProductItems> product = this.productService.getAllProduct();
		model.addAttribute("productList", product);
		return "home";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";

	}

	@RequestMapping("/login")
	public String login() {
		return LOGIN;

	}

	@PostMapping("/login")
	public String checkLoginData(@RequestParam("userName") String userName, @RequestParam("password") String password,
			HttpSession session, Model model) {
		List<ProductItems> product = this.productService.getAllProduct();
		model.addAttribute("productList", product);
		session.setAttribute("name", userName);

		if (services.validateCustomer(userName, password)) {
			Customer cust = this.services.servicesForAdmin(userName);

			if (cust.getRole().contentEquals("admin")) {
				return "redirect:/admin";
			}
			return "redirect:home";
		}
		String errormsg = "Invalid Input ";
		model.addAttribute("error", errormsg);
		return LOGIN;

	}

	@PostMapping("/admin")
	public String adminpage() {
		return "home";
	}

	@RequestMapping("/registration")
	public String registerCustomer() {
		return "registration";
	}

	@PostMapping("/registration")
	public String validation(CustomerDto customerDto, Model model) {
		if (services.insertCustomerData(customerDto) != null) {
			return LOGIN;
		}
		String error = "Already Exist";
		model.addAttribute("error", error);
		return "registration";

	}

	@PostMapping("/search")
	public @ResponseBody List<ProductItems> getProductBySearch(@RequestBody String productName) {
		//logger.info("search button clicked" + productName);
		JSONObject jsonObj = new JSONObject(productName);
		String name = jsonObj.getString("productName");
		if (name.trim().isEmpty()) {
			name = "";
		}
		//logger.info("name " + name);
		return this.productService.getProductBySearch(name);
	}

	@RequestMapping("/buy")
	public String buy(@RequestParam("product_id") int productId, Model model) {
		ProductItems productDetails = productService.getProductById(productId);
		model.addAttribute("product", productDetails);

		return "buy";
	}

	@RequestMapping("/cart1")
	public String cart() {
		return "cart";

	}

	@GetMapping("/cart")
	public String addCartt(@RequestParam("product_id") int productId, Model model) {
		//logger.info(productId);
		ProductItems productDetails = productService.getProductById(productId);
		model.addAttribute("product", productDetails);
		return "cart";
	}

	@RequestMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:home";

	}

}
