package main;

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
	
	// open file containing adjacency list
	public LinkedList[] OpenFile() throws IOException
	{
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		
		LinkedList[] adjList = new LinkedList[DESTINATIONS];
		
		for (int i = 0; i < DESTINATIONS; i++){
			String[] textPart = textReader.readLine().split(" -> ");
			adjList[i] 		  = formLinkedList(textPart);
		}
		
		textReader.close();
		return adjList;
	}
	
	public LinkedList formLinkedList(String[] textPart)
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
				cur = cur.next;
			}
		}
		
		return head;
	}
}
