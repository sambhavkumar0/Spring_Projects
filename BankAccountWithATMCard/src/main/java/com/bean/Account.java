package com.bean;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type")
public class Account {
	@Id
	@Column(name="account_number")
	private int accountNumber;
	@Column(name="holder_name")
	private String holderName;
	
	private  double balance;
    @OneToOne(mappedBy="account", cascade=CascadeType.ALL)
    @JsonManagedReference
	private ATMCard atmCard;
	
	public Account() {
		
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public ATMCard getAtmCard() {
		return atmCard;
	}
	public void setAtmCard(ATMCard atmCard) {
		this.atmCard = atmCard;
	}
	
	
	


}