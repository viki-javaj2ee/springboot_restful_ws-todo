package com.todo.rest.webservices.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

	public static void main(String[] args) {
		
		String password = "my_passwors";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(password);
		System.out.println(String.format("Encoded passsword for %s is :%s",password,encodedPassword));
	}
}
