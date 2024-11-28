package com.infosys.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "coachtable")
public class CoachEntity {
	@Id
	@GenericGenerator(strategy="com.infosys.utility.CoachIdGenerator", name = "coach_id")
	@GeneratedValue(generator="coach_id_generator")
	private String coachId;
	private String name;
	private String password;
	private char gender;
	private LocalDate dateOfBirth;
	private long mobileNumber;
	private String speciality;
	@OneToMany(mappedBy = "coach")
	private Set<BookingEntity> coaches;
	
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
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public Set<BookingEntity> getCoaches() {
		return coaches;
	}
	public void setCoaches(Set<BookingEntity> coaches) {
		this.coaches = coaches;
	}

}
