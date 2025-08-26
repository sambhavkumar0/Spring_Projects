package com.model;

import jakarta.validation.constraints.*;

public class Admission {
    
	@NotBlank(message = "Child name should not be blank")
	private String childName;

	@NotBlank(message = "Contact Number should not be blank")
	private String contactNumber; 

	@Min(value = 2, message = "Age must be greater than or equal to 2")
    @Max(value = 7, message = "Age must be lesser than or equal to 7")
	private int age;

	@NotBlank(message = "Email id should not be blank")
	@Email(message = "Email format is not valid")
	private String emailId;
    
	private String programName;

	// Standard Getters and Setters
	public String getChildName() { return childName; }
	public void setChildName(String childName) { this.childName = childName; }
	public String getContactNumber() { return contactNumber; }
	public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public String getEmailId() { return emailId; }
	public void setEmailId(String emailId) { this.emailId = emailId; }
	public String getProgramName() { return programName; }
	public void setProgramName(String programName) { this.programName = programName;}
}