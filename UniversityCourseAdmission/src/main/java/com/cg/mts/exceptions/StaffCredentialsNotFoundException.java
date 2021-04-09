package com.cg.mts.exceptions;

@SuppressWarnings("serial")
public class StaffCredentialsNotFoundException extends RuntimeException {
	
	public StaffCredentialsNotFoundException(String message) {
		super(message);
	}

}
