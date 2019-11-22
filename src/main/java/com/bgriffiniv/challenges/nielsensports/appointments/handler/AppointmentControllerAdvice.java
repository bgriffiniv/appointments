package com.bgriffiniv.challenges.nielsensports.appointments.handler;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppointmentControllerAdvice extends ResponseEntityExceptionHandler {
	@ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
	protected ResponseEntity<String> handleTransactionException(IllegalArgumentException ex) {
		String message = ex.getMessage();
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotFoundException.class)
	protected ResponseEntity<String> handleTransactionException(NotFoundException ex) {
		String message = ex.getMessage();
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}
}
