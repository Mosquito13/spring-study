package com.mosquito.springstudy.controller;

public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8858028062030667274L;

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}

}
