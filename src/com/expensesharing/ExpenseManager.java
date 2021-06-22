package com.expensesharing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.expensesharing.models.User;
import com.expensesharing.models.expense.ExpenseType;
import com.expensesharing.models.expensesplit.ExpenseSplit;
import com.expensesharing.services.ExpenseService;
public class ExpenseManager {
	 Map<String,User> userMap;
	 Map<String,Map<String,Double>> outstandingAmountMap;
	
	
	
	public ExpenseManager() {
		userMap = new HashMap<String,User>();
		outstandingAmountMap = new HashMap<String,Map<String,Double>>();
	}

	public void createUser(int userId, String name, String email, String mobileNo)
	{
		User newUser = new User(userId,name, email, mobileNo);
		userMap.put(name,newUser);
		outstandingAmountMap.put(name , new HashMap<String,Double>());
	}
	
	public void addExpense(User paidBy, List<ExpenseSplit> splits, ExpenseType expenseType,
			double amount)
	{
		switch(expenseType)
		{
			case EXACT:
				ExpenseService.createExpense(paidBy,splits,ExpenseType.EXACT, amount);
			break;
			case EQUAL:
				ExpenseService.createExpense(paidBy,splits,ExpenseType.EQUAL, amount);
		}
		for(ExpenseSplit split : splits)
		{
			String paidTo = split.getUser().getName();
			Map<String,Double> balances = outstandingAmountMap.get(paidBy.getName());
			if(!balances.containsKey(paidTo))
			{
				balances.put(paidTo,0.0);
			}
			balances.put(paidTo, balances.get(paidTo)+split.getAmount());
			balances = outstandingAmountMap.get(paidTo);
			if(!balances.containsKey(paidBy.getName()))
			{
				balances.put(paidBy.getName(),0.0);		
			}
			balances.put(paidBy.getName(), balances.get(paidBy.getName())-split.getAmount());
		}
	}
	public void showBalance(String userName)
	{
		Map<String,Double> mp = outstandingAmountMap.get(userName);
		boolean isPrint = false;
		for(Map.Entry<String, Double> entry : mp.entrySet())
		{
			String name = entry.getKey();
			double amount = entry.getValue();
			isPrint = true;
			if(amount>0)
			{
				System.out.println(name+" OWES "+userName+" "+Math.abs(amount));
			}
			else 
			{
				System.out.println(userName+" OWES "+name+" "+Math.abs(amount));
			
			}
		}
		if(!isPrint)
		{
			System.out.println("NO balance");
		}
	}
	public void showBalance()
	{
		boolean isPrint = false;
		for(Map.Entry<String, Map<String,Double>> allEntry: outstandingAmountMap.entrySet())
		{
			for(Map.Entry<String, Double> entry : allEntry.getValue().entrySet())
			{
				String name = entry.getKey();
				double amount = entry.getValue();
				isPrint = true;
				if(amount>0)
				{
					System.out.println(name+" OWES "+allEntry.getKey()+" "+Math.abs(amount));
				}
				else 
				{
					System.out.println(allEntry.getKey()+" OWES "+name+" "+Math.abs(amount));
				
				}			
			}
		}
		if(!isPrint)
		{
			System.out.println("NO balance");
		}
	}
}
