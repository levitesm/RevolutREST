package DataModel;

import java.util.LinkedList;

import Types.AccId;
import Types.UsId;

public class User {

	private final UsId ID;
	private String fName;
	private String lName;
	private int age;
	private long telNum;
	private String address;
	
	private LinkedList<AccId> accounts;
	
	private static long lastId=0;
	
	
	public User(String fName, String lName, int age, long telNum, String address) {
		super();
		this.ID=new UsId(++lastId);
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.telNum = telNum;
		this.address = address;
		
		this.accounts = new LinkedList<>();
	}
	
	public UsId getID() {
		return ID;
	}

	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getTelNum() {
		return telNum;
	}
	public void setTelNum(long telNum) {
		this.telNum = telNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public LinkedList<AccId> getAccounts() {
		return accounts;
	}
	

	
	
}
