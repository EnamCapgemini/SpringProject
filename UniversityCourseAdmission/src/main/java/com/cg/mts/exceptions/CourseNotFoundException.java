package com.cg.mts.exceptions;

public class CourseNotFoundException extends RuntimeException {
	private String operation;

	public CourseNotFoundException(String message) {
		super(message);
	}


}
