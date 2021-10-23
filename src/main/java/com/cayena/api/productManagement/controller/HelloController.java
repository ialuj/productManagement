package com.cayena.api.productManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {
	
	@GetMapping
	public String welcomeHome() {
		return "Welcome to Cayena Product Stock Management API!";
	}

}
