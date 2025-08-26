package com.service;

import org.springframework.stereotype.Service;

import com.model.Customer;

//use appropriate annotation to configure CustomerService
@Service
public class CustomerService {
    
	public int validateInfo(Customer customer) {
		//Write the logic to validate the customer's email address and mobile number.
		//when both are valid return 1
		//when email is invalid return -2
		//when mobile number is invalid return -1
		 String email = customer.getEmailId();
	     long mobile = customer.getMobileNumber();

	        // Stricter email regex pattern for validation
	        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
	        String mobileStr = String.valueOf(mobile);
	        String mobilePattern = "^[6-9][0-9]{9}$";

	        boolean emailValid = (email != null) && email.matches(emailPattern);
	        boolean mobileValid = (mobileStr != null) && mobileStr.matches(mobilePattern);

	        // Debug output (optional - remove/comment out after testing)
	        System.out.println("Email: " + email + " | valid: " + emailValid);
	        System.out.println("Mobile: " + mobile + " | valid: " + mobileValid);

	        if (emailValid && mobileValid) {
	            return 1;
	        } else if (!mobileValid) {
	            return -1;
	        } else {  // email invalid
	            return -2;
	        }
}
}