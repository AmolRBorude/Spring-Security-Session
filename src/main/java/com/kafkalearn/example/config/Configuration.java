package com.kafkalearn.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class Configuration {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)
	{
		return http.build();
		
	}

}
