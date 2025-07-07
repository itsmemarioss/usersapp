package com.mc.auth.simple.repository;

import com.mc.auth.simple.dao.Password;
import com.mc.auth.simple.dao.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthenticationRepository {

	private List<User> users = Arrays.asList(new User("admin", new Password("admin")));

	public boolean save(User user){
		users.set(0, user);
		return true;
	}

	public Optional<User> findByUsername(String username){
		return users.stream().filter( us -> us.getName().equals(username)).findFirst();
	}

	public int count(){
		return users.size();
	}

}
