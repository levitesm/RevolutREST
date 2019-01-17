package Exceptions;

import Types.AccId;

public class NoSuchAccountException extends Exception {

	
	public NoSuchAccountException(AccId id) {
		this("No account found for ID: "+id);
		
	}
	private NoSuchAccountException(String str) {
		super(str);
		
	}
	

}