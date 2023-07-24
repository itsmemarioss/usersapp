package com.mc.auth.simple.repository;

import com.mc.auth.simple.dao.Password;
import com.mc.auth.simple.dao.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuthenticationRepositoryTest {

	AuthenticationRepository repository = new AuthenticationRepository();

	@Test
	public void testInsertion(){
		Assertions.assertTrue(repository.save(new User("user", null)));
	}

	@Test
	public void testFind(){
		Assertions.assertTrue(repository.save(new User("user", new Password("xxx"))));
		Assertions.assertNotNull(repository.findByUsername("user"));
	}

	@Test
	public void testAdminUserExists(){
		Assertions.assertNotNull(repository.findByUsername("admin"));
	}
}
