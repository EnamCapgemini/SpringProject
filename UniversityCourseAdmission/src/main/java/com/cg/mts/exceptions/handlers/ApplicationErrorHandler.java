package com.cg.mts.exceptions.handlers;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.mts.exceptions.DuplicateStaffCredentialsException;
import com.cg.mts.exceptions.StaffCredentialsNotFoundException;

@ControllerAdvice
public class ApplicationErrorHandler {
	
	@ExceptionHandler(DuplicateStaffCredentialsException.class)
	public ResponseEntity<?> handleDuplicateEntity(DuplicateStaffCredentialsException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();
		
		errorBody.put("error", "Creation Failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());
		
		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StaffCredentialsNotFoundException.class)
	public ResponseEntity<?> handleMissingEmployee(StaffCredentialsNotFoundException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();
		
		errorBody.put("error", "Not Found");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());
		
		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}

}
