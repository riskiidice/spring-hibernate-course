package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		return "index";
	}
	@GetMapping("/leaders")
	public String showLeader() {
		return "leaders/leaders";
	}
	@GetMapping("/systems")
	public String showSystems() {
		return "systems/systems";
	}
}
