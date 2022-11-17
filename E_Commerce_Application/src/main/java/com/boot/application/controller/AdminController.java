package com.boot.application.controller;

import java.io.IOException;
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
import com.boot.application.entity.ProductItems;
import com.boot.application.service.ProductService;
import com.boot.application.util.ImageUploader;

@MultipartConfig
@Controller
public class AdminController {

	@Autowired
	ProductService productService;

	@Autowired
	ImageUploader imageUploader;

	@Value("${upload.image}")
	private String path;

	@RequestMapping("/admin")
	public String adminLogin(Model m, HttpSession session) {
		List<ProductItems> products = this.productService.getAllProduct();
		System.out.println(products);
		m.addAttribute("products", products);
		return "admin";
	}

	@PostMapping("/addproduct")
	public @ResponseBody ResponseStatus<String> addProduct(@ModelAttribute ProductIteamDto dto) throws IOException {

		System.out.println("Dto from conroller :" + dto);

		String filename = imageUploader.uploadImage(path, dto.getImg());
		System.out.println("From controller" + filename);
		dto.setImage(filename);
		this.productService.insertProduct(dto);
		return new ResponseStatus<String>(200, "success");

	}

	@PostMapping(path = "/getproductbyid",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseStatus<ProductItems> getProductById(@RequestBody String pid) {
		System.out.println("pid : "+pid);
		
		 JSONObject orderJson = new JSONObject(pid); 
		 int prodId = orderJson.getInt("productId");
		 
		System.out.println(prodId);

		ProductItems product = this.productService.getProductById(prodId);
		return new ResponseStatus<>(200, product);


	}
	
	@GetMapping("/delete")
	public String deleteProductById(@RequestParam("product_id") int productId, Model model) {
		System.out.println(productId);
		productService.deleteProduct(productId);
		return "redirect:admin";
		
	}
	
	

	@PostMapping("/updateproduct")
	public @ResponseBody ResponseStatus<String> updateProduct(@ModelAttribute ProductIteamDto dto) throws IOException {
		System.out.println("update Product Called with the data : " + dto);
		this.imageUploader.setId(dto.getProductId());
		String filename = this.imageUploader.uploadImage(path, dto.getImg());
		dto.setImage(filename);
		this.productService.updateProduct(dto);
		return new ResponseStatus<>(200, "success");
	}

	@PostMapping("dashboard")
	public String dashboard() {
		return "dashboard";
	}
}