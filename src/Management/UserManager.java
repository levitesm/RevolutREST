package Management;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import DataModel.*;
import Exceptions.NoSuchAccountException;
import Exceptions.NoSuchUserException;
import Types.AccId;
import Types.UsId;

public class UserManager{

	private static HashMap<UsId, User> users = new HashMap<>();
	 
	public static Set<UsId> getAllUserIds(){
		return users.keySet();
	}
	
	public static User getUserById(UsId id) throws NoSuchUserException
	{
		if(users.containsKey(id)) 
			return users.get(id);
		else
			throw new NoSuchUserException(id);
	}
	
	public static UsId addNewUser(String fName, String lName, int age, long telNum, String address)
	{
		User u = new User(fName, lName, age, telNum, address);
		users.put(u.getID(), u);
		return u.getID();
	}
	
		public static UsId addNewUser(String fName)
	{
		return addNewUser(fName, "", 0, 0, "");
		
	}
	
	public static UsId addNewUser()
	{
		return addNewUser("");
		
	}
	
	public static void deleteUserById(UsId id) throws NoSuchUserException
	{
		if(users.containsKey(id)) 
		{
			LinkedList<AccId> l =  (LinkedList<AccId>) users.get(id).getAccounts().clone();
			for(AccId a:l)
				try {
					AccountManager.deleteAccountById(a);
				} catch (NoSuchAccountException e) {
					System.err.println("UNEXPECTED ERROR IN USERS STRUCTURE!!!");
				}
			users.remove(id);
		}
			
		else
			throw new NoSuchUserException(id);
	}
}
