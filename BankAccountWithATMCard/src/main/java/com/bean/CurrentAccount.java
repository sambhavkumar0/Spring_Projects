package com.bean;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
@Entity
@DiscriminatorValue("CURR")
public class CurrentAccount extends Account {
	@Column(name="od_limit")
	private double ODLimit;

	public CurrentAccount() {
		
	}

	public double getODLimit() {
		return ODLimit;
	}
public void setODLimit(double oDLimit) {
		ODLimit = oDLimit;
}
	
	
}