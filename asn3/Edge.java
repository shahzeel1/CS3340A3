//This class creates the edge node for the graph
public class Edge {
	private int v1;
	private int v2;
	private int weight;
	
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
