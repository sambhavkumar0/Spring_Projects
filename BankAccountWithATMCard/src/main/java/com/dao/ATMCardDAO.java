package com.dao;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.ATMCard;
import com.bean.Account;
import com.repository.AccountRepository;
@Service
public class ATMCardDAO {
	
    // SLF4J Logger instance
    private static final Logger logger = LoggerFactory.getLogger(ATMCardDAO.class);

    @Autowired // Injects the AccountRepository dependency
    private AccountRepository accountRepository;
	
	public void issueATMCardToAccount(int accountNumber, ATMCard atmCardObjet) {
			//fill code
		 Optional<Account> optionalAccount = accountRepository.findById(accountNumber);

	        if (optionalAccount.isPresent()) {
	            Account account = optionalAccount.get();
	            // Check if the account does not already have a card
	            if (account.getAtmCard() == null) {
	                // Establish the bi-directional link
	                account.setAtmCard(atmCardObjet);
	                atmCardObjet.setAccount(account);
	                
	                // Save the account. The new ATMCard will be saved due to cascading.
	                accountRepository.save(account);
	                
	                // Log the success message
	                logger.info("ATM card successfully issued to account number {}", accountNumber);
	            } else {
	                // Log the error message if a card already exists
	                logger.error("ATM card not issued to account number {}", accountNumber);
	            }
	        } else {
	            // Log the error message if the account is not found
	            logger.error("ATM card not issued to account number {}", accountNumber);
}}

}