package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Registration;
import com.service.EventService;

// use appropriate annotation
@Controller
public class EventController {
	
	// use appropriate annotation
	@Autowired
	private EventService service;
	
	// use appropriate annotation
	 @ModelAttribute("eventTypeList")
	public List<String> populateEventType(){		

		//Fill the code
		 return service.getEventCostMap().keySet().stream().collect(Collectors.toList());		
	}	
	 @GetMapping("/showPage")
	public String showPage(@ModelAttribute("registration")Registration registration) {			
		
		//Fill the code
		
		 return "showPage";
	}
	
	 @PostMapping("/register")
	public String registerEvent(@ModelAttribute("registration")@Valid Registration registration, BindingResult result,ModelMap model) {
		
		//Fill the code
		  if (result.hasErrors()) {
	            // Validation errors, return to form page to show errors
	            return "showPage";
	        }
	        // Calculate registration cost
	        double cost = service.calculateRegistrationCost(registration);
	        String message = "Dear " + registration.getParticipantName() + ", You have to pay Rs." + cost;
	        model.addAttribute("message", message);
	        return "showPage";
	}
}