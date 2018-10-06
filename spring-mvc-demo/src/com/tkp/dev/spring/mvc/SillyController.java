package com.tkp.dev.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {
	
	@RequestMapping("/showForm")
	public String getTheForm() {
		return "silly";
	}
	
}
