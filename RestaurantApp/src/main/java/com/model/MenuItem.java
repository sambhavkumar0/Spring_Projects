package com.model;

public class MenuItem
{
	 private String name;
	 private String cuisine;
	 private double price;
	 
	public MenuItem(String name, String cuisine, double price) {
		super();
		this.name = name;
		this.cuisine = cuisine;
		this.price = price;
	}

	public MenuItem() {
		super();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	 
   
 
   
    
}