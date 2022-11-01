package com.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.entity.User;
import com.spring.mvc.services.UseService;

@Controller
public class UserController {
	@Autowired
	private UseService useService;

	public UserController() {
		System.out.println("User Controller");
	}

	@RequestMapping("/")
	public String index() {
		System.out.println("Index");
		return "index";
	}

	@RequestMapping("login")
	public String login() {
		return "login";

	}

	@PostMapping("login")
	public String validateUser(@RequestParam("userEmail") String useremail,
			@RequestParam("userPassword") String userpassword, Model m) {
		System.out.println("login controller");
		System.out.println("useremail ="+useremail);
		System.out.println("userpassword ="+userpassword);
		if (useremail != null && userpassword != null)
		{

			m.addAttribute("useremail", useremail);
			if (useService.validateUser(useremail, userpassword))
				return "dashboard";
			
			

		}
//		map.put("email", user.getUserEmail());
		String error = "Invalid Input";
		m.addAttribute("errormsg", error);
		return "login";

	}

	@RequestMapping("register")
	public String register() {
		return "register";

	}

	@PostMapping("register")
	public String insertUser(User user, Model m) 
	{

		System.out.println("register Controller");
		System.out.println(user);
		if (user.getUserEmail() != null && user.getUserId() > 0 && user.getUserPassword() != null) 
		{
			if (useService.inseretUser(user))
				return "login";
			
		}
		String error = "Invalid Input";
		m.addAttribute("errormsg", error);

		return "register";
	}
}
