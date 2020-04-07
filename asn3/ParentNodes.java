/**
 * 
 * 
 * This class creates the edge node for the graph
 * @author Zeel Shah
 * 250970094
 *
 */
public class ParentNodes {
	private int parentid; // stores the final id for MST
	private int key;// stores final key for MST
	
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
