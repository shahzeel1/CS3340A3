import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * Main Function for Prim MST reads in file, creates graph and calculated MST
 * @author Zeel Shah
 *
 */
public class PrimMain {
	public static void main (String[] args)
	{

		try {
			File file = new File(args[0]); // get file
			Scanner myReader = new Scanner (file);

			String vString = myReader.nextLine();// read num of vertices
		
			
			int vertices = Integer.parseInt(vString);
			PrimMST graph = new PrimMST(vertices);
			
			String line;
			int v1, v2, weight;
			System.out.println("Input graph:");
			
			while(myReader.hasNext())
			{
				line = myReader.nextLine(); // get the values of vertices and weight of edge
				StringTokenizer tok = new StringTokenizer (line);
				v1=Integer.parseInt(tok.nextToken());
				v2=Integer.parseInt(tok.nextToken());
				weight=Integer.parseInt(tok.nextToken());
				System.out.println(v1+" - "+v2+" weight: "+weight);
				graph.addEdge(v1, v2, weight);// add edge to the graph
			}
			
			System.out.println(" ");

			graph.MST();// call the PrimMST calculator


		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		
	}



}
