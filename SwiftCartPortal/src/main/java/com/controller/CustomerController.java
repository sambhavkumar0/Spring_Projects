package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import com.model.Customer;
import com.service.CustomerService;

//use appropriate annotation to configure the CustomerController class
@Controller
public class CustomerController {
	// Use appropriate annotation for automatic dependency injection
	@Autowired
	CustomerService service;

	// Render the registration page and populate the model attribute "customer" with
	// a new Customer object.
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String registrationPage(@ModelAttribute("customer") Customer customer) {
		//Fill the code here
		return "index";
	}

// Validate the customer registration information and returns appropriate success or error page.
	 @RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
	public String validateInfo(@ModelAttribute("customer") Customer customer) {

		//Fill the code here
		 int validationResult = service.validateInfo(customer);

	        if (validationResult == 1) {
	            return "success";
	        } else if (validationResult == -1) {
	            return "invalidMobileNumber";
	        } else if (validationResult == -2) {
	            return "invalidEmail";
	        } else {
	            return "index";
	        }
}

}