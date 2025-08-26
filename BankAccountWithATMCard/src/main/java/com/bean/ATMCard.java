package com.bean;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Date;

@Entity
@Table(name="atm_card")
public class ATMCard {
	@Id
	@Column(name="card_number")
	private String cardNumber;
	@Column(name="card_type")
	private String cardType;
	@Column(name="expiry_date")
	private Date expiryDate;
	@Column(name="cvv_number")
	private int cvvNumber;
	@OneToOne
	@JoinColumn(name="account_number")
	@JsonBackReference
	private Account account;
	
	public ATMCard() {
		
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getCvvNumber() {
		return cvvNumber;
	}
	public void setCvvNumber(int cvvNumber) {
		this.cvvNumber = cvvNumber;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account =account;
	}

}