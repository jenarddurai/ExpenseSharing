package com.expensesharing.models.expensesplit;

import com.expensesharing.models.User;

public class ExpenseSplit {
	int id;
	double amount;
	User user;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ExpenseSplit(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
