package com.mc.auth.simple.service;

import com.mc.auth.simple.dao.User;
import com.mc.auth.simple.repository.AuthenticationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

	private final AuthenticationRepository authenticationRepository;

	public AuthenticationService(
			AuthenticationRepository authenticationRepository) {
		this.authenticationRepository = authenticationRepository;
	}

	public boolean saveUser(User user){
		return authenticationRepository.save(user);
	}

	public boolean login(User user){
		Optional<User> existingUser = authenticationRepository.findByUsername(user.getName());
		return existingUser.map(value -> value.getPassword().equals(user.getPassword())).orElse(false);
	}

}
