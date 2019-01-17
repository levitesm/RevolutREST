package Types;

public class AccId {

	private String ID;
	
	public AccId(long num)
	{
		this.ID=new String("ACC|"+num);
	}

	@Override
	public String toString() {
		
		return ID;
	}

	
}
