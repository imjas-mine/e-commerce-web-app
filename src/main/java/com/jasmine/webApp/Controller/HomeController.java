package com.jasmine.webApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String greet() {
		System.out.println("hello world");
		return "Hello world";
	}
	@RequestMapping("/about")
	public String about() {
		return "I am about section";
	}
}
