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
		
		LinkedList[] adjList = new LinkedList[COUNTRIES];
		int j, k;
		
		for (int i = 0; i < SIZE; i++){
			LinkedList cur;
			String[] textPart = textReader.readLine().split(",");
			j = Integer.parseInt(textPart[0]);
			//System.out.println("textPart[0]: " + j);
			k = Integer.parseInt(textPart[1]);
			//System.out.println("textPart[1]: " + k);
			if (adjList[j] == null) adjList[j] = new LinkedList(k);
			else{
				cur = adjList[j];
				while (cur.next != null) cur = cur.next;
				cur.addNeighbour(k);
			}
			if (adjList[k] == null) adjList[k] = new LinkedList(j);
			else{ 	
				cur = adjList[k];
				while (cur.next != null) cur = cur.next;				
				cur.addNeighbour(j);
			}
		}
		
		textReader.close();
		return adjList;
	}
}
