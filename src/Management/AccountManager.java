package Management;

import java.util.*;

import DataModel.*;
import Exceptions.NoSuchAccountException;
import Exceptions.NoSuchUserException;
import Types.AccId;
import Types.UsId;

public class AccountManager {

	private static HashMap<AccId, Account> accounts = new HashMap<>();
	 
	public static Set<AccId> getAllAccountIds(){
		return accounts.keySet();
	}
	
	public static Account getAccountById(AccId id) throws NoSuchAccountException
	{
		if(accounts.containsKey(id)) 
			return accounts.get(id);
		else
			throw new NoSuchAccountException(id);
	}
	
	public static AccId addNewAccount(UsId userId) throws NoSuchUserException
	{
		User user = UserManager.getUserById(userId);
		Account a = new Account(user);
		accounts.put(a.getID(), a);
		return a.getID();
	}
	
	public static void deleteAccountById(AccId id) throws NoSuchAccountException
	{
		if(accounts.containsKey(id)) 
			{
			accounts.get(id).getUser().getAccounts().remove(id);
			accounts.remove(id);
			
			}
		else
			throw new NoSuchAccountException(id);
	}
	
	public static String printAccountBalances(AccId id) throws NoSuchAccountException
	{
		StringBuffer str = new StringBuffer("");
		if(accounts.containsKey(id)) {System.out.println("Account "+id);
			for(Balance b :accounts.get(id).getBalances()) str.append(b.getCur() + " : " + b.getBalace() + "\n");
		}else
			throw new NoSuchAccountException(id);
		
		return str.toString();
	}
	
}
