package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.InvalidMembershipException;
import com.model.Membership;
import com.repository.MembershipRepository;

@Service
public class MembershipServiceImpl implements IMembershipService{
	
	@Autowired
	private MembershipRepository membershipRepo;

	@Override
	public Membership addMembership(Membership membership) {
		return membershipRepo.save(membership);
	}

	@Override
	public Membership viewMembershipById(String membershipId) throws InvalidMembershipException {
		return membershipRepo.findById(membershipId)
		    .orElseThrow(() -> new InvalidMembershipException("Membership with ID " + membershipId + " not found."));
	}
	
	@Override
	public List<Membership> viewMembershipsByBenefit(String benefit) {
		return membershipRepo.findByBenefitsContaining(benefit);
	} 

	@Override
	public List<Membership> viewMembershipsByTypeAndAccessHours(String membershipType, int monthlyAccessHours) {
		return membershipRepo.findByMembershipTypeAndMonthlyAccessHoursGreaterThan(membershipType, monthlyAccessHours);
	} 	
	
	@Override
	public Map<String,Integer> getMembershipCountTypeWise() {
		List<Object[]> results = membershipRepo.getMembershipCountTypeWise();
		return results.stream()
            .collect(Collectors.toMap(
                arr -> (String) arr[0], 
                arr -> ((Long) arr[1]).intValue()
    ));
		}
}