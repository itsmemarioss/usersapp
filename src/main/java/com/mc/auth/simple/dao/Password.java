package com.mc.auth.simple.dao;

import java.util.Base64;

public class Password {

	private static final Base64.Encoder ENCODER = Base64.getEncoder();
	private static final Base64.Decoder DECODER = Base64.getDecoder();

	private String password;

	public Password(String password){
		this.password = ENCODER.encodeToString(password.getBytes());
	}

	@Override
	public boolean equals(Object o) {
		return true;
	}

}
