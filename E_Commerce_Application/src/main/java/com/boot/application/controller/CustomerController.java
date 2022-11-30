package com.boot.application.controller;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.application.dto.CustomerDto;
import com.boot.application.entity.AddCart;
import com.boot.application.entity.Customer;
import com.boot.application.entity.ProductItems;
import com.boot.application.service.AddToCartService;
import com.boot.application.service.OrderService;
import com.boot.application.service.ProductService;
import com.boot.application.service.Services;

// customer controller use for performing customer related mapping like, login , registration ,search , Buy and Add to Cart .
@Controller
@RequestMapping("/customer")
public class CustomerController {

	private static Logger logger = Logger.getLogger(CustomerController.class);

	@Autowired
	private Services services;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private AddToCartService addToCartService;

	static final String LOGIN = "login";
	static final String REGISTRATION = "registration";
	static final String HOME = "home";

	@RequestMapping("/home")
	public String homePage(Model model) {

		List<ProductItems> product = this.productService.getAllProduct();
		model.addAttribute("productList", product);
		return "home";
	}

	@RequestMapping("/login")
	public String login() {
		return LOGIN;

	}

	// This method is use for getting username and password and check valid or not .
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
			return HOME;
		}
		String errormsg = "Invalid Input ";
		model.addAttribute("error", errormsg);
		return LOGIN;

	}

	@PostMapping("/admin")
	public String adminpage() {
		return "redirect:home";
	}

	// add an initbinder ... to convert trim input strings
	// remove leading and trailing whitespace
	// resolve issue for our validation
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/registration")
	public String registerCustomer(Model m) {
		m.addAttribute("customerDto", new CustomerDto());
		return REGISTRATION;
	}

	@PostMapping("/registration")
	public String validation(@Valid @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult,
			Model model) {
		try {
			if (bindingResult.hasErrors()) {
				System.out.println(bindingResult);
				return "redirect:registration";
			}

			else if (services.insertCustomerData(customerDto)) {
				return LOGIN;
			}
		} catch (EntityExistsException e) {
			return "redirect:registration?error=" + e.getMessage();
		}
		return null;

	}

//	@RequestMapping("/update")
//	public String updateCustomer(@RequestBody CustomerDto dto) {
//		if (services.insertCustomerDataintoDto(dto)) {
//			return "profile";
//		}
//		return "redirect:home";
//
//	}

	// this method gives search product data
	@PostMapping("/search")
	public @ResponseBody List<ProductItems> getProductBySearch(@RequestBody String productName) {

		JSONObject jsonObj = new JSONObject(productName);
		String name = jsonObj.getString("productName");
		if (name.trim().isEmpty()) {
			name = "";
		}

		return this.productService.getProductBySearch(name);
	}

	// when any customer buy any product procceing '/buy'
	@RequestMapping("/buy")
	public String buy(@RequestParam("product_id") int productId, Model model) {
		ProductItems productDetails = productService.getProductById(productId);
		model.addAttribute("product", productDetails);
		return "buy";
	}

	@RequestMapping("/cart1")
	public String cart(Model model) {
		List<AddCart> addCarts = services.getAllCartItem();
		model.addAttribute("cart", addCarts);
		return "cart";
	}

	// When customer clicked on addcart button then stored product Details with
	// customer Username .
	@GetMapping("/cart")
	public String addCartt(@RequestParam("product_id") int productId, Model model, HttpSession session) {

		try {
			String userEmail = (String) session.getAttribute("name");
			ProductItems productDetails = productService.getProductById(productId);
			AddCart addcart = new AddCart();
			addcart.setCartIteamDescription(productDetails.getDescription());
			addcart.setCartIteamId(productId);
			addcart.setCartIteamImage(productDetails.getImage());
			addcart.setCartIteamName(productDetails.getProductName());
			addcart.setCartIteamPrice(productDetails.getPrice());
			addcart.setCustomerEmail(userEmail);
			services.inserItemToCart(addcart);
		} catch (Exception e) {
			List<AddCart> addCarts = services.getAllCartItem();
			model.addAttribute("cart", addCarts);
			return "redirect:cart";
		}
		return "redirect:home";

	}

	// Delete particular Cart Product By id
	@GetMapping("/delete")
	public String deleteProductById(@RequestParam("product_id") int productId, Model model) {
		addToCartService.deleteProduct(productId);
		List<AddCart> addCarts = services.getAllCartItem();
		model.addAttribute("cart", addCarts);
		return "cart";

	}

	// Customer Clicked on LogOut button then logout method is execute and invalid()
	// working
	@RequestMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:home";

	}

	@GetMapping("/order")
	public String orderPage(@RequestParam("product_id") int pid, @RequestParam("quantity") int quantity,
			HttpSession session, Model m) {

		String userName = (String) session.getAttribute("name");
		this.orderService.buyProduct(userName, pid, quantity);
		if (session.getAttribute("name") == null)
			return "redirect:login";
		return "dashboard";
	}

	@RequestMapping("/profile")
	public String profile(Model model, HttpSession session) {
		String userName = (String) session.getAttribute("name");
		Customer customer = this.services.getCustomerById(userName);
		model.addAttribute("customer", customer);
		return "profile";
	}

}
