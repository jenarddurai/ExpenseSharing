package com.expensesharing.models;

public class User {
	int userId;
	String name;
	String email;
	String mobileNo;
	
	
	
	public User(int userId, String name, String email, String mobileNo) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
}