import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile
{
	public final static int SIZE = 2000;
	public final static int COUNTRIES = 50;
	private String path;
	
	public ReadFile(String file_path)
	{
		path = file_path;
	}
	
	public LinkedList[] OpenFile() throws IOException
	{
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		
		LinkedList[] linkedList = new LinkedList[COUNTRIES];
		int j, k;
		
		for (int i = 0; i < SIZE; i++){
			String[] textPart = textReader.readLine().split(",");
			
			j = Integer.parseInt(textPart[0]);
			k = Integer.parseInt(textPart[1]);
			
			populateAdjList(linkedList, j, k);
		}
		
		textReader.close();
		return linkedList;
	}

	public void populateAdjList(LinkedList[] linkedList, int j, int k)
	{
		LinkedList cur;
		
		// undirected graph
		// J -> K
		if (linkedList[j] == null) linkedList[j] = new LinkedList(k);
		else{
			cur = linkedList[j];
			while (cur.next != null) cur = cur.next;
			cur.addNeighbour(k);
		}
					
		// K -> J
		if (linkedList[k] == null) linkedList[k] = new LinkedList(j);
		else{ 	
			cur = linkedList[k];
			while (cur.next != null) cur = cur.next;				
			cur.addNeighbour(j);
		}
	}
}
