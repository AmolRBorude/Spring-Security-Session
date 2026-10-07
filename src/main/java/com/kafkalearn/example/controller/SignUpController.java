package com.kafkalearn.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafkalearn.example.entity.EmployeeSignUp;
import com.kafkalearn.example.repo.EmployeeRepo;

@RestController
public class SignUpController {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	@PostMapping("/signup")
	public String signUp(@RequestBody EmployeeSignUp employeeSignUp)
	{
		employeeSignUp.setPassword(encoder.encode(employeeSignUp.getPassword()));
		employeeRepo.save(employeeSignUp);
		return "Employee Registered";
	}

}
