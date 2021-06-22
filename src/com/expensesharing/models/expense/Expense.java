package com.expensesharing.models.expense;

import java.util.List;

import com.expensesharing.models.User;
import com.expensesharing.models.expensesplit.ExpenseSplit;

public abstract class Expense {
	int id;
	User paidBy;
	List<ExpenseSplit> splits;
	ExpenseType expenseType;
	double amount;
	abstract boolean isValid();


	public Expense(User paidBy, List<ExpenseSplit> splits, ExpenseType expenseType,
			double amount) {
		super();
		this.paidBy = paidBy;
		this.splits = splits;
		this.expenseType = expenseType;
		this.amount = amount;
	}



	public ExpenseType getExpenseType() {
		return expenseType;
	}



	public void setExpenseType(ExpenseType expenseType) {
		this.expenseType = expenseType;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getPaidBy() {
		return paidBy;
	}
	public void setPaidBy(User paidBy) {
		this.paidBy = paidBy;
	}
	public List<ExpenseSplit> getSplits() {
		return splits;
	}
	public void setSplits(List<ExpenseSplit> splits) {
		this.splits = splits;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
