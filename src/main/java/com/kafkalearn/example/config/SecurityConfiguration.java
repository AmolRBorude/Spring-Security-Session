package com.kafkalearn.example.config;

import com.kafkalearn.example.SpringSecurityProjectApplication;
import com.kafkalearn.example.controller.SecurityController;
import com.kafkalearn.example.service.CustomeUserDetailService;

import org.springframework.security.authentication.CachingUserDetailsService;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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

   
    	http.authorizeHttpRequests(auth->auth
    			.requestMatchers("/home","/signup").permitAll()
    			.anyRequest().authenticated())
    	.httpBasic(Customizer.withDefaults())
    	.formLogin(Customizer.withDefaults())
    	.csrf(csrf->csrf.disable());
        return http.build();
    }
    
//    @Bean
//    public UserDetailsService userDetailsService()
//    {
//    	UserDetails user1 = User
//    			.withUsername("abc")
//    			.password("{noop}123")
//    			.roles("USER")
//    			.build();
//    	UserDetails user2 = User
//    			.withUsername("amol")
//    			.password("{noop}123")
//    			.roles("USER")
//    			.build();
//		return new InMemoryUserDetailsManager(user1,user2);
//    }
    
    @Bean
    public UserDetailsService userDetailsService()
    {
       return new CustomeUserDetailService();
    }
    
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {

        DaoAuthenticationProvider authProvider =
                new DaoAuthenticationProvider(userDetailsService());
                authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

      return  authProvider;

    }
}