package Management;

import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import DataModel.*;
import Exceptions.NoSuchAccountException;
import Exceptions.NoSuchCerrencyException;
import Exceptions.NotEnoughMoneyException;
import Exceptions.WrongAmountException;
import Types.AccId;
import Types.Currency;
import Types.TransType;

public class TransactionManager {
	
	private static LinkedList<Transaction> transactions = new LinkedList<>();
	
public static LinkedList<Transaction> getTransactionList()
{
	return transactions;
}

public static LinkedList<Transaction> getTransactionList(AccId acc)
{
	LinkedList<Transaction> l = new LinkedList<Transaction>();
	for(Transaction t : transactions)
	{
		if(t.getUserIds().contains(acc)) l.add(t);
	}
	return l;
}

public static LinkedList<Transaction> getTransactionList(TransType type)
{
	LinkedList<Transaction> l = new LinkedList<Transaction>();
	for(Transaction t : transactions)
	{
		if(t.getType()==type) l.add(t);
	}
	return l;
}

public static LinkedList<Transaction> getTransactionList(AccId acc, TransType type)
{
	LinkedList<Transaction> l = new LinkedList<Transaction>();
	for(Transaction t : transactions)
	{
		if(t.getType()==type && t.getUserIds().contains(acc)) l.add(t);
	}
	return l;
}


public static void putMoney(AccId to, double sum, Currency toCur) throws NoSuchAccountException, WrongAmountException
{
	
	Account a=AccountManager.getAccountById(to);
	
	
	a.addMoney(sum, toCur);
	
	
	transactions.add(new Transaction(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()), TransType.PUT, new LinkedList<AccId>(Arrays.asList(to)), "Money input to AccountId " + to +" : "+sum+" ("+toCur+")"));
}

public static void withdrawMoney(AccId from, double sum, Currency fromCur) throws NoSuchAccountException, NotEnoughMoneyException, NoSuchCerrencyException, WrongAmountException
{
	
	Account a=AccountManager.getAccountById(from);
	
	
	a.getMoney(sum, fromCur);
	
	
	transactions.add(new Transaction(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()), TransType.WITHDRAW, new LinkedList<AccId>(Arrays.asList(from)), "Money withdraw from AccountId " + from +" : "+sum+" ("+fromCur+")"));
}

public static void transferMoney(AccId from, AccId to, double sum, Currency fromCur, Currency toCur) throws NoSuchAccountException, NotEnoughMoneyException, NoSuchCerrencyException, WrongAmountException
{
	
	Account a1=AccountManager.getAccountById(from);
	Account a2=AccountManager.getAccountById(to);
	
	a1.getMoney(sum, fromCur);
	a2.addMoney(sum*fromCur.getRate()/toCur.getRate(), toCur);
	
	
	transactions.add(new Transaction(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()), TransType.TRANSFER, new LinkedList<AccId>(Arrays.asList(from,to)), "Money transfer from AccountId " + from + " to AccountId "+ to +" : "+sum+" ("+fromCur+"->"+toCur+")"));
}

public static void transferMoney(AccId from, AccId to, double sum, Currency fromCur) throws NoSuchAccountException, NotEnoughMoneyException, NoSuchCerrencyException, WrongAmountException
{
	transferMoney(from, to, sum, fromCur, fromCur);
}

public static void transferMoney(AccId from, double sum, Currency fromCur, Currency toCur) throws NoSuchAccountException, NotEnoughMoneyException, NoSuchCerrencyException, WrongAmountException
{
	transferMoney(from, from, sum, fromCur, toCur);
}


}
