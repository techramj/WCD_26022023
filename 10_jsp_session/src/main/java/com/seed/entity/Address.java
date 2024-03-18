package com.seed.entity;

public class Address {

	private String city;
	private int pincode;
	private LandMark landmark;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public LandMark getLandmark() {
		return landmark;
	}

	public void setLandmark(LandMark landmark) {
		this.landmark = landmark;
	}

}
