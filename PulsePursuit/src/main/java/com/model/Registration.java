package com.model;

import java.util.*;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.*;

// use appropriate annotation
@Component
public class Registration {
	//provide necessary annotation for validation
	@NotBlank(message = "Participant Name cannot be empty")
	private String participantName;
	
	//provide necessary annotation for validation
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number should have 10 digits and first digit should be 6,7 ,8 or 9")
	private String phoneNumber;
	
	//provide necessary annotations for validation
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
	private String email;
	
    //provide necessary annotations for validation
    @Min(value = 18, message = "Age must be greater than 18")
    @Max(value = 25, message = "Age must be smaller than 25")
	private int age;

	private String eventType;
	
	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType =eventType;
	}
}