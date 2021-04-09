package com.cg.mts.exceptions;

@SuppressWarnings("serial")
public class DuplicateAdmissionException extends RuntimeException {
	
	public DuplicateAdmissionException(String message) {
		super(message);
	}

}
