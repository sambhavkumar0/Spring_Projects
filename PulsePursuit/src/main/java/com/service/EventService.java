package com.service;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.model.Registration;

// use appropriate annotation
@Service
public class EventService {
	
	  private static final Map<String, Double> eventCosts = Map.of(
		        "GolfTournament", 2000.0,
		        "Triathlon", 1000.0,
		        "Marathon", 1200.0,
		        "HikingChallenge", 1500.0
		    );
	public double calculateRegistrationCost(Registration registration) {
		
		  double regCost = eventCosts.getOrDefault(registration.getEventType(), 0.0);
	        double totalCost = regCost + (regCost * 0.18);
	        return totalCost;
	}
    public Map<String, Double> getEventCostMap() {
        return eventCosts;
}
}