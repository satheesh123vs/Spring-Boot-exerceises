package com.example.demo.configs;

public class UsernameNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	String message;

	public UsernameNotFoundException() {
		super();
	}

	public UsernameNotFoundException(String message) {
		super(message);
		this.message = message;
	}
}