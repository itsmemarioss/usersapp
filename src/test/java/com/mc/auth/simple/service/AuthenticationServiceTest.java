package com.mc.auth.simple.service;

import com.mc.auth.simple.dao.Password;
import com.mc.auth.simple.dao.User;
import com.mc.auth.simple.repository.AuthenticationRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {

	@Spy
	private AuthenticationRepository repository;

	private AuthenticationService service;

	@BeforeEach
	void setUp() {
		service = new AuthenticationService(repository);
	}

	@Test
	void saveMethodShouldCallRepository() {
		service.saveUser(new User("user", null));
		Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());
	}

	@Test
	@Disabled
	void loginShouldFailIfAWrongPasswordIsProvided() {
		service.saveUser(new User("user", new Password("xxx")));
		Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());
		boolean success = service.login(new User("user", new Password("test")));
		Mockito.verify(repository, Mockito.times(1)).findByUsername(Mockito.any());
		log.info("User logged in {}", success);
		assertThat(success).isFalse();
	}

	@Test
	@Disabled
	void usersCountShouldIncreaseAfterSavingANewUser() {
		var expectedValue = repository.count() + 1;
		service.saveUser(new User("user", new Password("test")));
		assertThat(repository.count()).isEqualTo(expectedValue);
	}

}
