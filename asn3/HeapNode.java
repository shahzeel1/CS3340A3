/**
 * This class creates the heap nodes for the heap
 * @author Zeel Shah
 * 250970094
 *
 */
public class HeapNode {
	private int id;// node id
	private int key;// node key
	
	public HeapNode(int id, int key)
	{
		this.id = id;
		this.key = key;
	}
	
	public void setKey(int newKey)
	{
		this.key = newKey;
	}

	
	public int getKey()
	{
		return key;
	}
	public int getId()
	{
		return id;
	}
}
