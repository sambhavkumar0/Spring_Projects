package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.model.Registration;
import com.service.RegistrationService;


//use appropriate annotation to configure RegistrationController as Controller
@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService service;

	@GetMapping("/showPage")
	public String showPage(@ModelAttribute("registration") Registration registration) {
		return "showPage";
	}
	
	@ModelAttribute("sportsList")
	public List<String> populateSports() {
		List<String> sportsList = new ArrayList<>();
		sportsList.add("Cricket");
		sportsList.add("Football");
		sportsList.add("Hockey");
		sportsList.add("Badminton");
		sportsList.add("Tennis");
		return sportsList;
	}

	// invoke the service class - sportsRegistration method.
	@PostMapping("/registration")
	public String sportsRegistration(@ModelAttribute("registration") Registration registration, ModelMap model) {
		int fees = service.sportsRegistration(registration);
		String message = "Thanks for visiting. Your monthly fees for " + registration.getOptedSports() + " training is $" + fees;
		model.addAttribute("message", message);
		return "showPage";
	}
}