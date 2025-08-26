package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bean.Account;
import com.bean.CurrentAccount;
import com.bean.SavingsAccount;
import com.dao.AccountDAO;

@RestController
public class AccountController {

    @Autowired
    AccountDAO accountDao;

    // Method renamed for clarity to resolve test ambiguity
    @PostMapping("/openAccount/CURR")
    public void openCurrentAccount(@RequestBody CurrentAccount account) {
        accountDao.openAccount(account);
    }

    // Method renamed for clarity to resolve test ambiguity
    @PostMapping("/openAccount/SAV")
    public void openSavingsAccount(@RequestBody SavingsAccount account) {
        accountDao.openAccount(account);
    }

    @GetMapping("/retrieveAccountBasedOnCardType/{cardType}")
    public List<Account> retrieveAccountBasedOnCardType(@PathVariable("cardType") String cardType) {
        return accountDao.retrieveAccountBasedOnCardType(cardType);
}
}