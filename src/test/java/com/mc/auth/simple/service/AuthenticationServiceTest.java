package com.mc.auth.simple.service;

import com.mc.auth.simple.dao.Password;
import com.mc.auth.simple.dao.User;
import com.mc.auth.simple.repository.AuthenticationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceTest {

	@Mock
	private AuthenticationRepository repository;

	@InjectMocks
	private AuthenticationService service;

	@Test
	public void testInsertion() {
		service.saveUser(new User("user", null));
		Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());

	}

	@Test
	public void testLogin() {
		service.saveUser(new User("user", new Password("xxx")));
		Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());
		service.login(new User("user", new Password("test")));
		Mockito.verify(repository, Mockito.times(1)).findByUsername(Mockito.any());
	}

}
