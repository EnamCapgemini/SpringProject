package com.cg.mts.exceptions;

public class ApplicantNotFoundException extends RuntimeException{
	public ApplicantNotFoundException(String message) {
		super(message);
	}
}
