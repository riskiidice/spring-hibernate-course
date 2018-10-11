package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeContoller {
	@RequestMapping("/")
	public String homePage() {
		return "index";
	}
}
