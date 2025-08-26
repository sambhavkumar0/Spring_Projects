package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bean.ATMCard;
import com.dao.ATMCardDAO;
@RestController
public class ATMController {
	@Autowired
	private ATMCardDAO atmcardDao;
	@PostMapping("/issueATMCardToAccount/{accountNumber}")
	public void issueATMCardToAccount(@PathVariable("accountNumber")int accountNumber,@RequestBody  ATMCard atmCardObjet) {
			//fill code
		atmcardDao.issueATMCardToAccount(accountNumber, atmCardObjet);
	}

}