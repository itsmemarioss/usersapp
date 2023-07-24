package com.mc.auth.simple.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {

	private String name;
	private Password password;

}
