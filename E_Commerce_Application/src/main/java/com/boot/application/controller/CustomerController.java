package com.boot.application.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.boot.application.entity.AddCart;
import com.boot.application.entity.Customer;
import com.boot.application.entity.Order;
import com.boot.application.entity.ProductItems;
import com.boot.application.service.OrderService;
import com.boot.application.service.ProductService;
import com.boot.application.service.Services;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private Services services;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

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

		JSONObject jsonObj = new JSONObject(productName);
		String name = jsonObj.getString("productName");
		if (name.trim().isEmpty()) {
			name = "";
		}

		return this.productService.getProductBySearch(name);
	}

	@RequestMapping("/buy")
	public String buy(@RequestParam("product_id") int productId, Model model) {
		ProductItems productDetails = productService.getProductById(productId);
		model.addAttribute("product", productDetails);
		return "buy";
	}

	@RequestMapping("/cart1")
	public String cart(Model model) {
		List<AddCart> addCarts = services.getAllCartItem();
		System.out.println(addCarts);
		model.addAttribute("cart", addCarts);
		return "cart";

	}

	@GetMapping("/cart")
	public String addCartt(@RequestParam("product_id") int productId, Model model, HttpSession session) {

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
		return "redirect:cart1";
	}

	@RequestMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:home";

	}

	@GetMapping("/order")
	public String orderPage(HttpSession session, Model m) {

		if (session.getAttribute("name") == null)
			return "redirect:login";

		String customerRequestDto = (String) session.getAttribute("name");
		Customer customer = this.services.getCustomerById(customerRequestDto);
		System.out.println(customer);
		List<Order> orders = this.orderService.getAllOrderByUserName(customer);
		System.out.println(orders);

		m.addAttribute("orders", orders);
		return "order";
	}

}
