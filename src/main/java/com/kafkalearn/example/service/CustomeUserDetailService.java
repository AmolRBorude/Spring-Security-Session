package com.kafkalearn.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kafkalearn.example.entity.EmployeeSignUp;
import com.kafkalearn.example.repo.EmployeeSignupRepo;


@Service
public class CustomeUserDetailService implements UserDetailsService{
	
	@Autowired
	private EmployeeSignupRepo employeeRepo;

	 @Override
	    public UserDetails loadUserByUsername(String username)
	            throws UsernameNotFoundException {

	        EmployeeSignUp employee = employeeRepo.findByUsername(username);

	        if (employee == null) 
	        {
	            throw new UsernameNotFoundException(
	                    "User not found: " + username
	            );
	        }

	        return User
	                .withUsername(employee.getUsername())
	                .password(employee.getPassword())
	                .roles("USER")
	                .build();
	    }
	}