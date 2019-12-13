package com.ar1.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@GetMapping("/")
	public String home() {
		
		return ("<h1>hi</h1>");
	}
	
	@GetMapping("/user")
	public String user() {
		
		return ("<h1>user</h1>");
	}
	
	@GetMapping("/admin")
	public String admin() {
		
		return ("<h1>admin</h1>");
	}

}
