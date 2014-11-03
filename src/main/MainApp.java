package main;

import java.io.IOException;
import java.util.Vector;
import java.util.Scanner;

public class MainApp implements ConstantsInterface
{
	public static void main(String[] args)
	{
		long time;
		long start  	 	 = 0;
		long runs        	 = 10000;
		String[] cityNames   = new String[TOTAL_CITY_NAMES];
		Vector<City> adjList = new Vector<City>(TOTAL_CITIES);
		Scanner sc       	 = new Scanner(System.in);

		/* please edit the directory accordingly */
		String file_name = "src/txt/Graph (" + TOTAL_CITIES + ") TEST.txt";
		//String file_name = "storage/emulated/0/Codes/CZ2001-Graphs/src/txt/Graph (" + TOTAL_CITIES + ") TEST.txt";

		try{
			adjList   = ReadFile.openFile(file_name);
			//cityNames = ReadFile.openCityNamesFile();
		} 
		catch (IOException e){
			System.out.println(e.getMessage());
		}
		finally{
			//printAdjList(adjList);
			
			City origin = adjList.get(0);
			City end = adjList.get(19);
			BreadthFirstSearch.breadthFirstSearch(adjList, origin, end);
			
			System.out.println("Total number of cities: " + TOTAL_CITIES);
			System.out.println("Total number of edges : " + countEdge(adjList));
			
			sc.close();
		}
	}
	
	public static void printAdjList(Vector<City> adjList)
	{
		for(int i = 0; i < TOTAL_CITIES; i++){
			City city = adjList.get(i);
			
			System.out.print("[" + i + "] ");
			Vector<Integer> neighbourIndex = city.getNeighbourIndex();
			
			int j = 0;
		
			for(Integer neighbour : neighbourIndex){
				System.out.print(neighbour);
				
				if(j++ != neighbourIndex.size()-1){
					System.out.print(" -> ");
					}
			}
			
			System.out.println();
		}
	}
	
	public static long countEdge(Vector<City> adjList)
	{
		long count = 0;

		for (int i = 0; i < adjList.size(); i++){
			count += adjList.get(i).getEdges();
		}
		
		return count/2;
	}
}
