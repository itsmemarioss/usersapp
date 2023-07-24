package com.mc.auth.simple.controller;

import com.mc.auth.simple.dao.User;
import com.mc.auth.simple.service.AuthenticationService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("authentication")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("save")
	public boolean createUser(@RequestBody User user) {
		return authenticationService.saveUser(user);
	}

	@GetMapping("login")
	public boolean login(@RequestBody User user) {
		return authenticationService.login(user);
	}

	@SneakyThrows
	@PostMapping("update/{user}")
	public boolean update(@PathVariable String user, @RequestParam String password) {
		throw new NoSuchMethodException();
	}

	@SneakyThrows
	@DeleteMapping
	public boolean delete(@RequestBody String user, @RequestParam String password) {
		throw new NoSuchMethodException();
	}

}
