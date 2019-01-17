package Exceptions;

import Types.UsId;

public class NoSuchUserException extends Exception {

	
	public NoSuchUserException(UsId id) {
		this("No user found for ID: "+id);
		
	}
	private NoSuchUserException(String str) {
		super(str);
		
	}
	

}