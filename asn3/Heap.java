/**
 * 
 * This class creates the Heap Class
 * @author Zeel Shah
 * 250970094
 *

 *
 */
public class Heap {
	private int size; // size of the heap
	private boolean[] inHeap;// to see if the node is in the heap
	private HeapNode[] heap; // the actual heap
	private int[] indexes;// stores the actual index of each id

	/**
	 * Initialize the heap
	 * @param heap
	 * @param n
	 */
	public Heap(HeapNode[] heap, int n)
	{
		this.heap = heap;
		size =n;
		indexes = new int [n];
		inHeap = new boolean[n];
		
		// all ids are located at the index
		// all ids are in the heap
		for (int i =0; i<n; i++)
		{
			indexes[i]=i;
			inHeap[i] = true;
		}
	}

	/**
	 * checks to see if the id is in the heap
	 * @param id
	 * @return true if in heap, false otherwise 
	 */
	public boolean in_heap(int id)
	{
		return inHeap[id];
	}

	/**
	 * @return min key
	 */
	public HeapNode min_key()
	{
		return heap[0];
	}

	/**
	 * 
	 * @return min id
	 */
	public int min_id()
	{
		return heap[0].getId();
	}

	/**
	 * return the key located at the id given
	 * @param id
	 */
	public int key (int id)
	{
		return (heap[indexes[id]].getKey());
	}
	
	/**
	 * Extract the min node and delete
	 * @return
	 */
	
	public HeapNode delete_min()
	{
		HeapNode min = heap[0];
		HeapNode lastNode = heap[size-1];
		indexes[lastNode.getId()]=0; // set the location of the last node in the heap to the first index
		heap[0] = lastNode; // make the last node the min node
		heap[size-1] = null;
		sinkDown(0);// recalibrate the heap
		size--;
		return min;

	}

	/**
	 * set the key to the val given
	 * @param id
	 * @param new_key
	 */
	public void decrease_key(int id, int new_key)
	{
		HeapNode node = heap[indexes[id]];
		node.setKey(new_key);
		bubbleUp(indexes[id]); // recalibrate the heap based on the new key
	}

	/**
	 * re organize the heap to make it a min heap again
	 * @param id
	 */
	private void bubbleUp(int id)
	{
		int parentId = (id)/2;
		int curId = id;

		// if the parent is greater than the child swap
		while(curId>0 && heap[parentId].getKey()>heap[curId].getKey())
		{
			// get the nodes
			HeapNode curNode = heap[curId]; 
			HeapNode parentNode = heap[parentId];

			//swap
			indexes[curNode.getId()] = parentId;
			indexes[parentNode.getId()] = curId;
			swap(curId,parentId);
			curId = parentId; // make the parent the child and the child the parent
			parentId = parentId/2;

		}
	}

	/**
	 * recalibrate the heap after deleting the min node
	 * @param val
	 */
	private void sinkDown(int val)
	{
		int min = val+1; // start index with 1 to calculate the position in the heap
		int leftC = 2*(val+1); // left child
		int rightC = 2*(val+1)+1; // right child
		
		
		// make sure the left child is in the array and see if the key is less than the min key
		if (leftC<size && heap[min-1].getKey()>heap[leftC-1].getKey())
		{
			min = leftC;
		}
		
		//  make sure the right child is in the array and see if the key is less than the min key
		if (rightC<size && heap[min-1].getKey()>heap[rightC-1].getKey())
		{
			min = rightC;
		}
		// if the min id changed swap the indices
		if (min != (val+1))
		{
			HeapNode minNode = heap[min-1];
			HeapNode kNode = heap[val];

			//swap
			indexes [minNode.getId()]=val;	
			indexes [kNode.getId()]=min-1;
			swap (val,min-1);
			sinkDown(min-1); // repeat until everything is correct
		}
	}

	/**
	 * after removing key from the node remove set it as false in the heap
	 * @param i
	 * @param set
	 */
	public void setInHeap (int i, boolean set)
	{
		inHeap[i]=set;
	}
	
	/**
	 * swap function swaps the given values
	 * @param a
	 * @param b
	 */
	private void swap (int a, int b)
	{
		HeapNode temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	
	/**
	 * 
	 * @return true if heap is empty false is not
	 */
	public  boolean isEmpty()
	{
		return size ==0;
	}
}


