package com.service;

import org.springframework.stereotype.Service;
import com.model.Registration;

//use appropriate annotation to configure RegistrationService as a Service
@Service
public class RegistrationService {

	// Return the fees
	public int sportsRegistration(Registration registration) {
		String sport = registration.getOptedSports();
		int fees = 0;
		switch (sport) {
		case "Cricket":
			fees = 500;
			break;
		case "Football":
			fees = 350;
			break;
		case "Hockey":
			fees = 750;
			break;
		case "Badminton":
			fees = 400;
			break;
		case "Tennis":
			fees = 450;
			break;
		}
		return fees;
		}

}