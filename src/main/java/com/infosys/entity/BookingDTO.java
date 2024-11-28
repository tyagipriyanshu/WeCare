package com.infosys.entity;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class BookingDTO {
	
	private int bookingId;
	private String userId;
	private String coachId;
	
	@NotNull(message = "{slot.not.null}")
	private String slot;
	
	@NotNull(message = "{appointmentDate.not.null}")
	private LocalDate appointmentDate;
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCoachId() {
		return coachId;
	}
	public void setCoachId(String coachId) {
		this.coachId = coachId;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	

}
