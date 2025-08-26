package com.service;

import org.springframework.stereotype.Service;
import com.model.Account;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

//use appropriate annotation to configure AccountService as a Service
@Service
public class AccountService {

	// Return true if the password is valid 
	public boolean signup(Account account) {
		// fill the code
		String password = account.getPassword();

        // At least one letter, one digit, one special char, minimum 6 characters
        String regex = "^(?=.[A-Za-z])(?=.\\d)(?=.*[^A-Za-z0-9]).+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
	}

}