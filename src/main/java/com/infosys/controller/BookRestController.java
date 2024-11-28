package com.infosys.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.exception.WecareException;
import com.infosys.service.BookService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@Validated
public class BookRestController {
	@Autowired
	BookService bookService;
	
	@Operation(summary="Book an appointment")
	@PostMapping("/users/{userId}/booking/{coachId}")
	public ResponseEntity<Boolean> bookAppointment(@PathVariable("userId") String userId, @PathVariable("coachId") String coachId, @Valid @RequestBody Map<String, String> InputJson) 
			throws WecareException, ConstraintViolationException, MethodArgumentNotValidException{
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateOfAppointment = LocalDate.parse(InputJson.get("dateOfAppointment").toString(), dateFormat);
		String slot = InputJson.get("slot").toString();
		return ResponseEntity.ok().body(bookService.bookAppointment(userId, coachId, dateOfAppointment, slot));
	}
	
	@Operation(summary="Reschedule an appointment")
	@PutMapping("/booking/{bookingId}")
	public ResponseEntity<Boolean> rescheduleAppointment(@PathVariable  Integer bookingId, @Valid @RequestBody Map<String, String> InputJson) 
			throws WecareException, ConstraintViolationException, MethodArgumentNotValidException{
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateOfAppointment = LocalDate.parse(InputJson.get("dateOfAppointment").toString(), dateFormat);
		String slot = InputJson.get("slot").toString();
		return ResponseEntity.ok().body(bookService.rescheduleAppointment(bookingId, dateOfAppointment, slot));
	}
	
	@Operation(summary="Delete an appointment")
	@DeleteMapping("/booking/{bookingId}")
	public ResponseEntity<?> cancelAppointment(@PathVariable  Integer bookingId)throws WecareException, ConstraintViolationException{
		bookService.cancelAppointment(bookingId);
		return ResponseEntity.ok().build();
	}
}
