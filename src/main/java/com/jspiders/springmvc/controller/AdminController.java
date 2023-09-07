package com.jspiders.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.pojo.AdminPOJO;
import com.jspiders.springmvc.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	// create account page controller
	@GetMapping("/createAccount")
	public String createAccountPage(ModelMap map) {

		AdminPOJO adminPOJO = adminService.getAdmin();

		if (adminPOJO != null) {
			map.addAttribute("msg", "Account already exists...!");
			return "Login";
		}
		return "CreateAccount";

	}

	// Create Account Controller
	@PostMapping("/createAccount")
	public String createAccount(@RequestParam String username, @RequestParam String password, ModelMap map) {

		AdminPOJO adminPOJO = adminService.createAccount(username, password);

		// success
		if (adminPOJO != null) {
			map.addAttribute("msg", "Account created successfully...!");
			return "Login";
		}
		// Failure
		map.addAttribute("msg", "Account not created...!");
		return "Login";
	}

	// Login controller
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, ModelMap map) {

		AdminPOJO adminPOJO = adminService.login(username, password);

		// success
		if (adminPOJO != null) {
			return "Home";
		}

		// failure
		map.addAttribute("msg", "Invalid username password...!");
		return "Login";
	}

	// Logout controller
	@GetMapping("/logout")
	public String logout(ModelMap map) {
		map.addAttribute("msg", "Logged out successflly...!");
		return "Login";
	}
}
