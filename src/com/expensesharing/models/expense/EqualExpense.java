package com.expensesharing.models.expense;

import java.util.List;

import com.expensesharing.models.User;
import com.expensesharing.models.expensesplit.ExpenseSplit;

public class EqualExpense extends Expense {

	public EqualExpense(User paidBy, List<ExpenseSplit> splits, ExpenseType expenseType,
			double amount) {
		super(paidBy, splits, expenseType, amount);
		// TODO Auto-generated constructor stub
	}

	boolean isValid() {
		// TODO Auto-generated method stub
		double cur = 0;
		for(ExpenseSplit split: splits)
		{
			cur+=split.getAmount();
		}
		return cur==amount;
	}
}
