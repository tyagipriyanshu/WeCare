package com.infosys.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entity.BookingDTO;
import com.infosys.entity.ErrorMessage;
import com.infosys.entity.LoginDTO;
import com.infosys.entity.UserDTO;
import com.infosys.exception.WecareException;
import com.infosys.service.BookService;
import com.infosys.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/users")
public class UserRestController {
	
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;
	
	@Operation(summary="Create new account for User")
	@PostMapping
	public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userDTO, Errors errors)throws MethodArgumentNotValidException{
		if (errors.hasErrors()) {
			String response = "";
			response = errors.getAllErrors().stream().map(ObjectError::getDefaultMessage)
					.collect(Collectors.joining(","));
			ErrorMessage error = new ErrorMessage();
			error.setMessage(response);
			return ResponseEntity.badRequest().body(error.getMessage());
		}
		return ResponseEntity.ok().body(userService.createUser(userDTO));
	}
	
	@Operation(summary="Login for for User")
	@PostMapping("/login")
	public ResponseEntity<Boolean> loginUser(@Valid @RequestBody LoginDTO loginDTO) throws WecareException, MethodArgumentNotValidException{
		return ResponseEntity.ok().body(userService.loginUser(loginDTO));
	}
	
	@Operation(summary="Get User's Profile by its ID")
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getUserProfile(@PathVariable  String userId) throws WecareException, ConstraintViolationException{
		return ResponseEntity.ok().body(userService.getUserProfile(userId));
	}
	
	@Operation(summary="Get all scheduled appointments of user by its ID")
	@GetMapping("/booking/{userId}")
	public ResponseEntity<List<BookingDTO>> showMyAppointments(@PathVariable  String userId) throws WecareException, ConstraintViolationException{
		return ResponseEntity.ok().body(bookService.findBookingByUserId(userId));
	}
}
