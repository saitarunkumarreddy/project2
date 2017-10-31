package com.mygroup.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserProfile1 {

	@Id
	private String profileid;		
	private String fullname;
	private String emailid;
	private String mobileno;
	private String address;
	private String city;
	private String state;
	private String country;
	

	
	public String getProfileid() {
		return profileid;
	}
	public void setProfileId(String profileid) {
		this.profileid = profileid;
	}

	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}	
	
	@Override
	public String toString(){
		String val="";
		val = profileid + " - " + fullname + " - " + emailid + " - " + mobileno + " - " + address + " - " + city + " - " + state;
		return val;
		
	}
	
}
