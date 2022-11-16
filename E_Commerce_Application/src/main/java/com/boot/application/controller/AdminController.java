package com.boot.application.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
//		if (session.getAttribute("adminuser") == null) {
//			return "login";
//		}
		List<ProductItems> products = this.productService.getAllProduct();
		System.out.println(products);
		m.addAttribute("products", products);
		return "admin";
	}

	@PostMapping("/addproduct")
	public @ResponseBody ResponseStatus<String> addProduct(@ModelAttribute ProductIteamDto dto) throws IOException {
		
		
		System.out.println("Dto from conroller :" +dto);
		
		String filename = ImageUploader.uploadImage(path, dto.getImg());
		System.out.println("From controller" + filename);
		dto.setImage(filename);
		this.productService.insertProduct(dto);
		return new ResponseStatus<String>(200, "success");

	}

	@PostMapping("dashboard")
	public String dashboard() {
		return "dashboard";
	}
}