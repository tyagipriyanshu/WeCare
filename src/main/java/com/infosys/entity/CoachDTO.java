package com.infosys.entity;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CoachDTO {
	
	private String coachId;
	
	@NotNull(message = "{name.not.null}")
	@Size(min = 3,max = 50,message = "{name.size.invalid}")
	private String name;
	
	@NotNull(message = "{gender.not.null}")
	private char gender;
	
	@NotNull(message = "{dateOfBirth.not.null}")
	private LocalDate dateOfBirth;
	
	@NotNull(message="{password.not.null}")
	@Size(min = 5,max = 10,message = "{password.size.invalid}")
	private String password;
	
	@NotNull(message="{mobile.number.not.null}")
	@Pattern(regexp="(^$|[0-9]{10})",message = "{mobile.number.invalid}")
	private String mobileNumber;
	
	@NotNull(message="{speciality.not.null}")
	@Size(min = 3,max = 50,message = "{speciality.size.invalid}")
	private String speciality;
	
	public String getCoachId() {
		return coachId;
	}
	public void setCoachId(String coachId) {
		this.coachId = coachId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	

}
