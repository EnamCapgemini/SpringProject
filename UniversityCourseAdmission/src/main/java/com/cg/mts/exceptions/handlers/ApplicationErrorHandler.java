package com.cg.mts.exceptions.handlers;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//import com.cg.mts.entities.AdmissionCommiteeMember;
//import com.cg.mts.exceptions.AdmissionCommiteeMemberNotFoundException;

import com.cg.mts.exceptions.DataNotFoundException;

import com.cg.mts.exceptions.DuplicateDataException;
import com.cg.mts.exceptions.EmptyDataException;

@ControllerAdvice
public class ApplicationErrorHandler {

	@ExceptionHandler(DuplicateDataException.class)
	public ResponseEntity<?> handleDuplicateData(DuplicateDataException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();

		errorBody.put("error", "DUPLICATE DATA EXISTS");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());

		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmptyDataException.class)
	public ResponseEntity<?> handleEmptyData(EmptyDataException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();

		errorBody.put("error", "Empty database");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());

		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<?> handleDataNotFound(DataNotFoundException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();

		errorBody.put("error", ex.getOperation() + " failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());

		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	}
<<<<<<< HEAD

=======
>>>>>>> ad948675344f0578f508755cc4d02db7467c4445
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<?> handleBadCredentials(BadCredentialsException ex){
		Map<String, Object> errorBody = new LinkedHashMap<>();

		errorBody.put("error", "Login failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());

		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}
	
<<<<<<< HEAD

=======
>>>>>>> ad948675344f0578f508755cc4d02db7467c4445
}