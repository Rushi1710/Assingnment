package com.demo.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entity.UserData;
import com.demo.services.UserServicve;

@Controller
public class UserController {

	@Autowired
	private UserServicve userServicve;

	@RequestMapping("index")
	public String index() {
		return "index";
	}

	@RequestMapping("registration")
	public String registor() {
		String register = "registration";
		System.out.println(register);
		return register;
	}

	@PostMapping("registration")
	public String insertData(UserData userData) {
		System.out.println(userData);
		userServicve.inserUsertData(userData);
		return "login";

	}

	@RequestMapping("login")
	public String login() {
		return "login";
	}

	@PostMapping("login")
	public String validateUser(@RequestParam("username") String name, @RequestParam("password") String userpassword,
			Model model) {

		if (name != null && userpassword != null && userServicve.validateUser(name, userpassword)) {
			model.addAttribute("name", name);
			return "dashboard";
		}
		String error = "Invalid Input";
		model.addAttribute("errormsg", error);
		return "login";

	}

	@RequestMapping("update")
	public String update() {
		return "update";

	}

	@PostMapping("update")
	public String updateData(@RequestParam("username") String userName, @RequestParam("mobile") String mobile,
			@RequestParam("email") String email) {

		if (userServicve.updateData(userName, mobile, email)) {
			return "success";
		}
		return "update";

	}

}
