package com.baji.smartloan.auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.baji.smartloan.auth.dto.RegisterRequest;
import com.baji.smartloan.auth.entity.User;
import com.baji.smartloan.auth.repository.UserRepo;

@Service
public class AuthService {
	
	 private final UserRepo userRepository;

	    private final PasswordEncoder passwordEncoder;

	    public AuthService(
	            UserRepo userRepository,
	            PasswordEncoder passwordEncoder) {

	        this.userRepository = userRepository;
	        this.passwordEncoder = passwordEncoder;
	    }

	    public String register(RegisterRequest request) {

	        if (userRepository.existsByEmail(request.getEmail())) {

	            return "Email already registered";
	        }

	        User user = new User();

	        user.setName(request.getName());

	        user.setEmail(request.getEmail());

	        user.setPassword(
	                passwordEncoder.encode(request.getPassword()));

	        user.setRole("CUSTOMER");

	        userRepository.save(user);

	        return "Customer registered successfully";
	    }


}
