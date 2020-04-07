/**
 * This class creates the Prim Minimum Spanning Tree using the Heap class
 * @author Zeel Shah
 * 250970094
 *
 */
import java.util.LinkedList;

public class PrimMST {
	private int numVertices; // number of vertices in the graph
	LinkedList<Edge>[] edges; // list to store the edges

	/**
	 * @param v - number of vertices specified
	 * initialize the graph
	 */
	PrimMST(int v)
	{
		this.numVertices=v; 
		edges = new LinkedList[numVertices];

		for (int i=0; i<numVertices; i++)
		{
			edges[i] = new LinkedList<>(); // create empty edges 
		}
	}

	/**
	 * 
	 * @param v1
	 * @param v2
	 * @param weight
	 * insert edges given
	 */
	public void addEdge (int v1, int v2, int weight)
	{
		Edge edge1 = new  Edge (v1-1,v2-1,weight);
		edges[v1-1].addFirst(edge1);
		
		// for undirected graphs
		Edge edge2 = new Edge (v2-1,v1-1,weight);
		edges[v2-1].addFirst(edge2);
	}

	/**
	 * Create the Minimum Spanning Tree
	 */
	public void MST()
	{
		ParentNodes[] resSet = new ParentNodes [numVertices];// resulting tree nodes
		int[] key = new int[numVertices]; // stores all the keys
		HeapNode[] heap = new HeapNode[numVertices]; // heap

		// initialize the heap with all the veritces
		for (int i =0; i<numVertices; i++)
		{
			heap[i]= new HeapNode(i,Integer.MAX_VALUE); // temp vals
			resSet[i]= new ParentNodes(-1,Integer.MAX_VALUE); // -1 meaning no value is there yet
			key[i] = Integer.MAX_VALUE;
		}

		heap[0].setKey(0); // minimum node

		Heap minHeap = new Heap(heap, numVertices); // create the minimum heap

		while (!minHeap.isEmpty())
		{
			HeapNode min = minHeap.delete_min(); // extract min node

			int minId = min.getId(); // get the min id
			minHeap.setInHeap(minId,false); // value is not in the heap anymore

			//iterate through the edges
			LinkedList<Edge> list = edges[minId];
			for (int i = 0; i<list.size(); i++)
			{
				Edge edge = list.get(i);// get the edge

				// check if v2 is in the heap
				if(minHeap.in_heap(edge.getv2()))
				{
					int dest = edge.getv2(); // v2 is the destination vertex
					int newKey = edge.getWeight();

					//check if the new key is the minimum edge
					if(key[dest]>newKey)
					{
						minHeap.decrease_key(dest, newKey);
						// update result set
						resSet[dest].setParentId(minId);
						resSet[dest].setKey(newKey);
						key[dest]=newKey; // set the new min edge weight
					}
				}
			}
			
		
		}
		printMST(resSet);
	}



/**
 * Print the MST Tree
 * @param resSet
 */
	private void printMST(ParentNodes[] resSet)
	{
		int totalWeight =0; 
		System.out.println("Minimum Spanning Tree: ");
		for (int i=1; i< numVertices; i++)
		{
			System.out.println("Edge: " + (i+1) + "-" + (resSet[i].getParentId()+1) + " weight: "+ resSet[i].getWeight());
			totalWeight +=resSet[i].getWeight();
		}

		System.out.println("Total minimum key: " + totalWeight);
	}




}




