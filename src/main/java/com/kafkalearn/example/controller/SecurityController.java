package com.kafkalearn.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafkalearn.example.entity.Employee;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SecurityController {
	
	private List<Employee> list = new ArrayList<>(List.of(
		new Employee(101,"amol",21)));
	
	@GetMapping("/")
	public String simpleMsg()
	{
		return "Hi we are learning Spring Security...";
	}
	
	@GetMapping("/employee")
	public List<Employee> getEmp()
	{
		return list;
	}
	
	@PostMapping
	public void add(@RequestBody Employee emp)
	{
		list.add(emp);
	}
	
	@GetMapping("/id")
	public String sessionId(HttpServletRequest req)
	{
		return "Session ID : "+req.getSession().getId();
	}

}
