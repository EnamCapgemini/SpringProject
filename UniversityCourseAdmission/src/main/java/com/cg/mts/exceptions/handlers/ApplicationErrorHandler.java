package com.cg.mts.exceptions.handlers;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//import com.cg.mts.entities.AdmissionCommiteeMember;
//import com.cg.mts.exceptions.AdmissionCommiteeMemberNotFoundException;
import com.cg.mts.exceptions.AdmissionIdNotFoundException;

import com.cg.mts.exceptions.DataNotFoundException;

import com.cg.mts.exceptions.DuplicateDataException;
import com.cg.mts.exceptions.DuplicateStaffCredentialsException;
import com.cg.mts.exceptions.EmptyDataException;
import com.cg.mts.exceptions.UserNotFoundException;

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

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleMissingUser(UserNotFoundException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();

		errorBody.put("error", "Not Found");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());

		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}


	
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
	public ResponseEntity<?> handleDataNotFound(DataNotFoundException ex){
		Map<String, Object> errorBody = new LinkedHashMap<>();

		errorBody.put("error", ex.getOperation()+" failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());

		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AdmissionIdNotFoundException.class)
	public ResponseEntity<?> handleAdmissionId(AdmissionIdNotFoundException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();

		errorBody.put("error", "Not Found");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());

		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}

	
}