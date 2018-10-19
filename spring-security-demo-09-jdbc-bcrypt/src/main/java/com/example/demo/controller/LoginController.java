package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
//		return "auth/plain-login";
		return "auth/fancy-login";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "auth/access-denied";
	}
	
}
