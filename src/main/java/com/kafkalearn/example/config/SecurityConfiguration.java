package com.kafkalearn.example.config;

import com.kafkalearn.example.SpringSecurityProjectApplication;
import com.kafkalearn.example.controller.SecurityController;

import org.springframework.security.config.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final SecurityController securityController;

    private final SpringSecurityProjectApplication springSecurityProjectApplication;

    SecurityConfiguration(SpringSecurityProjectApplication springSecurityProjectApplication, SecurityController securityController) {
        this.springSecurityProjectApplication = springSecurityProjectApplication;
        this.securityController = securityController;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

   
    	http.authorizeHttpRequests(auth->auth.anyRequest().authenticated())
    	.httpBasic(Customizer.withDefaults());
        return http.build();
    }
}