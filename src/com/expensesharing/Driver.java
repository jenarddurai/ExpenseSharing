package com.expensesharing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.expensesharing.models.User;
import com.expensesharing.models.expense.ExpenseType;
import com.expensesharing.models.expensesplit.EqualSplit;
import com.expensesharing.models.expensesplit.ExactSplit;
import com.expensesharing.models.expensesplit.ExpenseSplit;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ExpenseManager expenseManager = new ExpenseManager();
		expenseManager.createUser(1, "user1", "jenard.nj@gmail.com", "8870217823");
		expenseManager.createUser(2, "user2", "richard.nj@gmail.com", "8870217825");
		expenseManager.createUser(3, "user3", "krishna.nj@gmail.com", "9970217823");
		expenseManager.createUser(4, "user4", "prasad.nj@gmail.com", "8834217823");
		while(true)
		{
		String inputStr = sc.nextLine();
		String[] input = inputStr.split(" ");
		String inputType = input[0];
		switch(inputType)
		{
			case "EXPENSE":
			{
				String paidBy = input[1];
				User paidByUser = expenseManager.userMap.get(paidBy);
				double amount = Double.parseDouble(input[2]);
				int noOfUsers = Integer.parseInt(input[3]);
				String expenseType = input[4+noOfUsers];
				List<ExpenseSplit> expenseSplit = new ArrayList<ExpenseSplit>();
				switch(expenseType)
				{
					case "EXACT":
						for(int i=0;i<noOfUsers; i++)
						{
							User curUser = expenseManager.userMap.get(input[4+i]);
							ExactSplit curSplit = new ExactSplit(curUser);
							curSplit.setAmount(Double.parseDouble(input[5+noOfUsers+i]));
							expenseSplit.add(curSplit);
						}
						expenseManager.addExpense(paidByUser, expenseSplit, ExpenseType.EXACT, amount);

						break;
					case "EQUAL":
						for(int i=0;i<noOfUsers; i++)
						{
							User curUser = expenseManager.userMap.get(input[4+i]);
							EqualSplit curSplit = new EqualSplit(curUser);
							expenseSplit.add(curSplit);						
						}
						expenseManager.addExpense(paidByUser, expenseSplit, ExpenseType.EQUAL, amount);
						break;				
				}
			}
			break;
			case "SHOW":
			{
				if(input.length>1)
				{
					String userName = input[1];
					expenseManager.showBalance(userName);
				}
				else
				{
					expenseManager.showBalance();
				}
			}
		}
		}
	}
}
