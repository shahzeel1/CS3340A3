
public class HeapNode {
	private int id;
	private int key;
	private boolean inHeap;
	public HeapNode(int id, int key)
	{
		this.id = id;
		this.key = key;
		this.inHeap = true;
	}
	
	public void setKey(int newKey)
	{
		this.key = newKey;
	}

	public void setInHeap(boolean set)
	{
		inHeap = set;
	}
	
	public boolean getInHeap ()
	{
		return inHeap;
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
