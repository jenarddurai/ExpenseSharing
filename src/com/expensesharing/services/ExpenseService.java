package com.expensesharing.services;

import java.util.List;

import com.expensesharing.models.User;
import com.expensesharing.models.expense.EqualExpense;
import com.expensesharing.models.expense.ExactExpense;
import com.expensesharing.models.expense.Expense;
import com.expensesharing.models.expense.ExpenseType;
import com.expensesharing.models.expensesplit.ExpenseSplit;

public class ExpenseService {
	public static Expense createExpense(User paidBy, List<ExpenseSplit> splits, ExpenseType expenseType,
			double amount)
	{
		switch(expenseType)
		{
		case EQUAL:
			double splitAmount = amount/splits.size();
			for(ExpenseSplit split: splits)
			{
				split.setAmount(splitAmount);
			}
			return new EqualExpense(paidBy, splits, expenseType, amount);

		case EXACT:
			return new ExactExpense(paidBy, splits, expenseType, amount);
		
		default:
			return null;
		}
	}
}
