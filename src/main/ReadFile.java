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
	public static String[] openCityNamesFile(String path) throws IOException
	{
		fr 		   		  = new FileReader(path);
		textReader 		  = new BufferedReader(fr);
		String[] cityName = new String[TOTAL_CITY_NAMES];
		
		for(int i = 0; i < TOTAL_CITY_NAMES; i++){
			do{
				cityName[i] = textReader.readLine().trim();
			}while(cityName[i].equals(""));
			
			//System.out.println(cityName[i]);
		}
		
		return cityName;
	}
	
	// open file containing adjacency list
	public static Vector<City> openGraphFile(String path) throws IOException
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
				city.addNeighbourIndex(Integer.parseInt(id));
			}
			
			adjList.add(city);
		}
		
		textReader.close();
		
		return adjList;
	}
}
