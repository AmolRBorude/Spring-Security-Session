package com.kafkalearn.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SecurityController {
	
	@GetMapping("/")
	public String simpleMsg()
	{
		return "Hi we are learning Spring Security...";
	}
	
	@GetMapping("/id")
	public String sessionId(HttpServletRequest req)
	{
		return "Session ID : "+req.getSession().getId();
	}

}
