package main;

import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile implements ConstantsInterface
{
	private static FileReader fr;
	private static BufferedReader textReader;
	
	// open file containing city names
	public static String[] openCityNamesFile() throws IOException
	{
		fr 		   		  = new FileReader(NAMES_PATH);
		textReader 		  = new BufferedReader(fr);
		String[] cityName = new String[TOTAL_CITY_NAMES];
		
		for(int i = 0; i < TOTAL_CITY_NAMES; i++){
			cityName[i] = textReader.readLine();
		}
		
		return cityName;
	}
	
	// open file containing adjacency list
	public static Vector<City> openFile(String path) throws IOException
	{
		fr 			  	     = new FileReader(path);
		textReader 	  	     = new BufferedReader(fr);
		Vector<City> adjList = new Vector<City>(TOTAL_CITIES);
		City city;
		
		for (int i = 0; i < TOTAL_CITIES; i++){
			city 		   = new City(i);
			String[] index = textReader.readLine().split(" -> ");
			
			// add neighbours to city based on adjacency list
			for(String id : index){
				city.addNeighbour(Integer.parseInt(id));
			}
			
			adjList.add(city);
		}
		
		textReader.close();
		
		return adjList;
	}
	
	/*public LinkedList formLinkedList(String[] textPart)
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
	}*/
}
