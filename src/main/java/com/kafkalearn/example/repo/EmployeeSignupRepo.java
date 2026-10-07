package com.kafkalearn.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kafkalearn.example.entity.EmployeeSignUp;

@Repository
public interface EmployeeSignupRepo extends JpaRepository<EmployeeSignUp, Integer>{

	EmployeeSignUp findByUsername(String username);
}
