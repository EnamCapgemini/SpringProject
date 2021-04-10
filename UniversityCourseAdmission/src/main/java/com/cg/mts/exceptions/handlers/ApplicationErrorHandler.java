package com.cg.mts.exceptions.handlers;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.mts.exceptions.ApplicantNotFoundException;
import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.exceptions.AdmissionCommiteeMemberNotFoundException;
import com.cg.mts.exceptions.AdmissionIdNotFoundException;

import com.cg.mts.exceptions.CourseNotFoundException;
import com.cg.mts.exceptions.DataNotFoundException;
import com.cg.mts.exceptions.DuplicateAdmissionCommiteeMemberException;
import com.cg.mts.exceptions.DuplicateStaffCredentialsException;
import com.cg.mts.exceptions.EmptyDataException;
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

	@ExceptionHandler(DuplicateAdmissionCommiteeMemberException.class)
	public ResponseEntity<?> handleDuplicateAdmissionCommiteeMember(DuplicateAdmissionCommiteeMemberException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();

		errorBody.put("error", "Creation Failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());

		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<?> handleDuplicate(CourseNotFoundException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();

		errorBody.put("error", "Not Found");
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
<<<<<<< Updated upstream
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<?> handleDataNotFound(DataNotFoundException ex){
		Map<String, Object> errorBody = new LinkedHashMap<>();

		errorBody.put("error", ex.getOperation()+" failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());

		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	}
	
=======

>>>>>>> Stashed changes
	@ExceptionHandler(ApplicantNotFoundException.class)
	public ResponseEntity<?> handleApplicantNotFound(ApplicantNotFoundException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();

		errorBody.put("error", "Not Found");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());

		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AdmissionIdNotFoundException.class)
	public ResponseEntity<?> handleAdmissionId(AdmissionIdNotFoundException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();

		errorBody.put("error", "Not Found");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());

		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AdmissionCommiteeMemberNotFoundException.class)
	public ResponseEntity<?> handleAdmissionAdmissionCommiteeMemberNotFound(AdmissionCommiteeMemberNotFoundException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();

		errorBody.put("error", "Not Found");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());

		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}
}