package com.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.model.Account;
import com.service.AccountService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//use appropriate annotation to configure AccountController as Controller
@Controller
public class AccountController {

//	Use appropriate annotation
	@Autowired
	private AccountService service;



	// invoke the service class - signup method.
	@GetMapping("/showPage")
    public String showPage(@ModelAttribute("account") Account account) {
        return "showPage";
    }
	 @PostMapping("/signUp")
	public String signup(@ModelAttribute("account") Account account, ModelMap model) {

		// fill the code
		  if (service.signup(account)) {
	            model.addAttribute("message", "Your Account is Created");
	        } else {
	            model.addAttribute("message", "Invalid Password");
	        }
	        return "showPage";
	}

}