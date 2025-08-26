package com.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.MenuItem;
import com.model.Restaurant;


//include the required annotation to make MenuRestController as RestController
@RestController  
public class MenuRestController {
      
	 private Restaurant restaurant = new Restaurant();
	    @GetMapping("/menu")
	    public List<MenuItem> getAllMenuItems()
	    {
	       
	         //Include the required business logic to return the list of menu items
	    	return restaurant.getMenuList();
	    	}
   
}