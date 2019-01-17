package Types;

public class UsId {

	private String ID;
	
	public UsId(long num)
	{
		this.ID=new String("US|"+num);
	}

	@Override
	public String toString() {
		
		return ID;
	}

	
}
