
public class ParentNodes {
	private int parentid; 
	private int key;
	
	ParentNodes(int parentid, int key)
	{
		this.parentid = parentid;
		this.key = key;
	}
	public void setParentId(int id)
	{
		parentid=id;
	}
	public void setKey(int key)
	{
		this.key=key;
	}

	public int getParentId()
	{
		return parentid;
	}
	public int getWeight()
	{
		return key;
	}
	
}
