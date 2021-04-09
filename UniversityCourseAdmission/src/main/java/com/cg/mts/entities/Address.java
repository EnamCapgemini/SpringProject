package com.cg.mts.entities;

import javax.persistence.OneToOne;

public class Address {
	private String city;
	private String state;
	private int pinCode;
	private String roadName;
	@OneToOne(mappedBy="admission")
	private Applicant applicant;
	public Address() {
		
	}
	public Address(String city, String state, int pinCode, String roadName) {
		super();
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.roadName = roadName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	@Override
	public String toString() {
		return "city=" + city + ", state=" + state + ", pinCode=" + pinCode
				+ ", roadName=" + roadName;
	} 
	
}
