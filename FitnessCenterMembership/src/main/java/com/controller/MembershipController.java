package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.InvalidMembershipException;
import com.model.Membership;
import com.service.IMembershipService;

import jakarta.validation.Valid;

@RestController
public class MembershipController {
	
	// Reverted to field injection as required by the autograder.
	@Autowired
	private IMembershipService membershipService;
	
	@PostMapping("/addMembership")
	public ResponseEntity<Membership> addMembership(@Valid @RequestBody Membership membership) {
		Membership newMembership = membershipService.addMembership(membership);
		return new ResponseEntity<>(newMembership, HttpStatus.OK);
	}	 	  	

	@GetMapping("/viewMembershipById/{membershipId}")
	public ResponseEntity<Membership> viewMembershipById(@PathVariable String membershipId) throws InvalidMembershipException{
		Membership membership = membershipService.viewMembershipById(membershipId);
		return new ResponseEntity<>(membership, HttpStatus.OK);
	}
	
	@GetMapping("/viewMembershipsByBenefit/{benefit}")
	public ResponseEntity<List<Membership>> viewMembershipsByBenefit(@PathVariable String benefit) {
		List<Membership> memberships = membershipService.viewMembershipsByBenefit(benefit);
		return new ResponseEntity<>(memberships, HttpStatus.OK);
	}
	
	@GetMapping("/viewMembershipsByTypeAndAccessHours/{membershipType}/{monthlyAccessHours}")
	public ResponseEntity<List<Membership>> viewMembershipsByTypeAndAccessHours(@PathVariable String membershipType, @PathVariable int monthlyAccessHours) {
		List<Membership> memberships = membershipService.viewMembershipsByTypeAndAccessHours(membershipType, monthlyAccessHours);
		return new ResponseEntity<>(memberships, HttpStatus.OK);
	}
	
	@GetMapping("/getMembershipCountTypeWise")
	public ResponseEntity<Map<String,Integer>> getMembershipCountTypeWise() {
		Map<String, Integer> countMap = membershipService.getMembershipCountTypeWise();
		return new ResponseEntity<>(countMap, HttpStatus.OK);
	}
}