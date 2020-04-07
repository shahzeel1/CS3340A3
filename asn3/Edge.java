/**
 * This class creates the edges for the graph
 * @author Zeel Shah
 * 250970094
 *
 */
public class Edge {
	private int v1;// starting vertex
	private int v2;//destination vertex
	private int weight;//weight of edge
	
	public Edge (int vertex1, int vertex2, int weight)
	{
		this.v1 = vertex1;
		this.v2 = vertex2;
		this.weight = weight;
		
	}
	public int getv2 () 
	{
		return v2;
	}
	public int getWeight()
	{
		return weight;
	}

}
