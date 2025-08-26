package com.bean;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
@Entity
@DiscriminatorValue("SAV")
public class SavingsAccount extends Account {
	@Column(name="minimum_balance")
	private double minimumBalance;

	public SavingsAccount() {
		
	}
	
	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	
	

}