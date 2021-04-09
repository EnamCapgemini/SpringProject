package com.cg.mts.exceptions;

@SuppressWarnings("serial")
public class DuplicateStaffCredentialsException extends RuntimeException {
	
	public DuplicateStaffCredentialsException(String message) {
		super(message);
	}

}
