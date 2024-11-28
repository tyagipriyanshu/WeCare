package com.infosys.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entity.BookingDTO;
import com.infosys.entity.CoachDTO;
import com.infosys.entity.ErrorMessage;
import com.infosys.entity.LoginDTO;
import com.infosys.exception.WecareException;
import com.infosys.service.BookService;
import com.infosys.service.CoachService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@Validated
@RequestMapping("/coaches")
public class CoachRestController {
	
	@Autowired
	CoachService coachService;
	@Autowired
	BookService bookService;
	
	@Operation(summary="Create new account for Life Coaches")
	@PostMapping
	public ResponseEntity<String> createCoach(@Valid @RequestBody CoachDTO coachDTO, Errors errors)throws MethodArgumentNotValidException{
		if (errors.hasErrors()) {
			String response = "";
			response = errors.getAllErrors().stream().map(ObjectError::getDefaultMessage)
					.collect(Collectors.joining(","));
			ErrorMessage error = new ErrorMessage();
			error.setMessage(response);
			return ResponseEntity.badRequest().body(error.getMessage());
		}	
		return ResponseEntity.ok().body(coachService.createCoach(coachDTO));
	}
	
	@Operation(summary="Login for life coaches")
	@PostMapping("/login")
	public ResponseEntity<Boolean> loginCoach(@Valid @RequestBody LoginDTO loginDTO)throws WecareException,MethodArgumentNotValidException{
		return ResponseEntity.ok().body(coachService.loginCoach(loginDTO));
	}
	
	@Operation(summary="Get Coach's Profile by its ID")
	@GetMapping("/{coachId}")
	public ResponseEntity<CoachDTO> getCoachProfile(@PathVariable  String coachId)throws ConstraintViolationException, WecareException{
		return ResponseEntity.ok().body(coachService.getCoachProfile(coachId));
	}
	
	@Operation(summary="Get all Life coaches' profile")
	@GetMapping("/all")
	public ResponseEntity<List<CoachDTO>> showAllCoaches()throws WecareException{
		return ResponseEntity.ok().body(coachService.showAllCoaches());
		
	}
	
	@Operation(summary="Get all scheduled appointments of coach by its ID")
	@GetMapping("booking/{coachId}")
	public ResponseEntity<List<BookingDTO>> showMySchedule(@PathVariable  String coachId)throws ConstraintViolationException,WecareException{
		return ResponseEntity.ok().body(bookService.findBookingByCoachId(coachId));
	}
	
}
