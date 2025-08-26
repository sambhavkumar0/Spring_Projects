package com.model;

//Use appropriate annotation
public class College {

	private String collegeName;
	private String location;
	private String offeringCourse;
	private double annualFees;

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOfferingCourse() {
		return offeringCourse;
	}

	public void setOfferingCourse(String offeringCourse) {
		this.offeringCourse = offeringCourse;
	}

	public double getAnnualFees() {
		return annualFees;
	}

	public void setAnnualFees(double annualFees) {
		this.annualFees = annualFees;
	}

	public College(String collegeName, String location, String offeringCourse, double annualFees) {
		super();
		this.collegeName = collegeName;
		this.location = location;
		this.offeringCourse = offeringCourse;
		this.annualFees = annualFees;
	}

	public College() {
		super();
	}

}
