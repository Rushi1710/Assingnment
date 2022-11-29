package com.boot.application.controller;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.application.dto.ProductIteamDto;
import com.boot.application.dto.ResponseStatus;
import com.boot.application.entity.Order;
import com.boot.application.entity.ProductItems;
import com.boot.application.service.OrderService;
import com.boot.application.service.ProductService;
import com.boot.application.util.ImageUploader;

// Admin controller in this class performing admin related mapping
@MultipartConfig
@Controller
public class AdminController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ImageUploader imageUploader;

	@Autowired
	private OrderService orderService;
	
	

	@Value("${upload.image}")
	private String path;

	// adminLogin() use for feching all product
	@RequestMapping("/admin")
	public String adminLogin(Model m, HttpSession session) {
		List<ProductItems> products = this.productService.getAllProduct();
		m.addAttribute("products", products);
		return "admin";
	}

	// This Method use for Adding Product to ProductItems Table
	@PostMapping("/addproduct")
	public @ResponseBody ResponseStatus<String> addProduct(@ModelAttribute ProductIteamDto dto) {
		String filename = imageUploader.uploadImage(path, dto.getImg());
		dto.setImage(filename);
		this.productService.insertProduct(dto);
		return new ResponseStatus<>(200, "success");

	}

	// getProductById() use for finding particular product by productId
	@PostMapping(path = "/getproductbyid", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseStatus<ProductItems> getProductById(@RequestBody String pid) {

		JSONObject orderJson = new JSONObject(pid);
		int prodId = orderJson.getInt("productId");
		ProductItems product = this.productService.getProductById(prodId);
		return new ResponseStatus<>(200, product);

	}

	// Delete particular product by id
	@GetMapping("/delete")
	public String deleteProductById(@RequestParam("product_id") int productId, Model model) {
		productService.deleteProduct(productId);
		return "redirect:admin";

	}

	// update any product by using updateProduct() , this method getting all updated
	// Details and update in productItems table
	@PostMapping("/updateproduct")
	public @ResponseBody ResponseStatus<String> updateProduct(@ModelAttribute ProductIteamDto dto) {

		this.imageUploader.setId(dto.getProductId());
		String filename = this.imageUploader.uploadImage(path, dto.getImg());
		dto.setImage(filename);
		this.productService.updateProduct(dto);
		return new ResponseStatus<>(200, "success");
	}

	// check product Quantity and give correct msg
	@PostMapping("/checkoutofstock")
	public @ResponseBody ResponseStatus<String> checkOutOfStocks(@RequestBody String pid, HttpSession session) {

		if (session.getAttribute("name") == null) {
			return new ResponseStatus<>(405, "Forbidden Request");
		}

		JSONObject orderJson = new JSONObject(pid);
		int prodId = orderJson.getInt("productId");
		if (this.orderService.checkOutOfStocks(prodId))
			return new ResponseStatus<>(200, "Product in Stocks");
		return new ResponseStatus<>(401, "Out Of Stock");
	}

	@RequestMapping("/order1")
	public String oreder(Model model,HttpSession session) {
	    
		if(session.getAttribute("name") != null) {
		List<Order> orderProduct = this.orderService.grtOrderbyuserName();
		model.addAttribute("orders", orderProduct);
		return "order";
		}
		return "redirect:/customer/login";

	}
	

}