import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile implements ConstantsInterface
{
	private static String path;
	
	public ReadFile(String file_path)
	{
		path = file_path;
	}
	
	// open raw data file
	public LinkedList[] OpenFile() throws IOException
	{
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		
		LinkedList[] adjList = new LinkedList[COUNTRIES];
		int j, k;
		
		for (int i = 0; i < SIZE; i++){
			String[] textPart = textReader.readLine().split(",");
			
			j = Integer.parseInt(textPart[0]);
			k = Integer.parseInt(textPart[1]);
			
			populateAdjList(adjList, j, k);
		}
		
		textReader.close();
		return adjList;
	}
	
	// open file containing adjacency list
	public static LinkedList[] OpenFile(String path) throws IOException
	{
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		
		LinkedList[] adjList = new LinkedList[COUNTRIES];
		
		for (int i = 0; i < COUNTRIES; i++){
			String[] textPart = textReader.readLine().split(" -> ");
			adjList[i] = formLinkedList(textPart);
		}
		
		textReader.close();
		return adjList;
	}

	public static void populateAdjList(LinkedList[] adjList, int j, int k)
	{
		LinkedList cur;
		
		// undirected graph
		// J -> K
		if (adjList[j] == null) adjList[j] = new LinkedList(k);
		else{
			cur = adjList[j];
			while (cur.next != null) cur = cur.next;
			cur.addNeighbour(k);
		}
					
		// K -> J
		if (adjList[k] == null) adjList[k] = new LinkedList(j);
		else{ 	
			cur = adjList[k];
			while (cur.next != null) cur = cur.next;				
			cur.addNeighbour(j);
		}
	}
	
	public static LinkedList formLinkedList(String[] textPart)
	{
		LinkedList head, cur;
		
		head = cur = null;
		
		for (int i = 0; i < textPart.length; i++){
			if (head == null){
				head = new LinkedList(Integer.parseInt(textPart[i]));
				cur  = head;
			}
			else{
				cur.addNeighbour(Integer.parseInt(textPart[i]));
			}
			cur = cur.next;
		}
		
		return head;
	}
}
