package main;

import java.io.IOException;
import java.util.Vector;
import java.util.Scanner;

public class MainApp implements ConstantsInterface
{
	private static String[] cityNames   = new String[TOTAL_CITY_NAMES];
	private static Vector<City> graph   = new Vector<City>(TOTAL_CITIES);
	
	public static void main(String[] args){
		long time;
		long start  	 	 = 0;
		long runs        	 = 10000;
		Scanner sc       	 = new Scanner(System.in);

		/* please edit the directory accordingly */
		String graph_path 	   = "src/txt/Graph (" + TOTAL_CITIES + ").txt";
		String city_names_path = "src/txt/City Names.txt";
		//String file_name = "storage/emulated/0/Codes/CZ2001-Graphs/src/txt/Graph (" + TOTAL_CITIES + ") TEST.txt";

		try{
			graph     = ReadFile.openGraphFile(graph_path);
			cityNames = ReadFile.openCityNamesFile(city_names_path);
		} 
		catch (IOException e){
			System.out.println(e.getMessage());
		}
		finally{
			//printAdjList(adjList);
			System.out.print("Enter origin: ");
			City origin = strToCity(sc.nextLine());
			System.out.print("Enter destination: ");
			City end = strToCity(sc.nextLine());
			printShortestRoute(BreadthFirstSearch.search(graph, origin, end));
			
			System.out.println("Total number of cities: " + TOTAL_CITIES);
			System.out.println("Total number of edges : " + countEdge(graph));
			
			sc.close();
		}
	}

	public static void printShortestRoute(Vector<City> route){
		for(int i = route.size()-1; i > 0; i--){
			System.out.print(cityNames[route.get(i).getIndex()] + " --> ");
		}

		System.out.println(cityNames[route.get(0).getIndex()]);
		System.out.println("Number of stop(s): " + (route.size()-1));
	} 
	
	public static void printAdjList(Vector<City> adjList){
		for(int i = 0; i < TOTAL_CITIES; i++){
			City city = adjList.get(i);
			
			System.out.print("[" + i + "] ");
			Vector<Integer> neighbourIndex = city.getNeighbourIndex();
			
			int j = 0;
		
			for(Integer neighbour : neighbourIndex){
				System.out.print(cityNames[neighbour]);
				
				if(j++ != neighbourIndex.size()-1){
					System.out.print(" -> ");
					}
			}
			
			System.out.println();
		}
	}
	
	public static long countEdge(Vector<City> adjList){
		long count = 0;

		for (int i = 0; i < adjList.size(); i++){
			count += adjList.get(i).getEdges();
		}
		
		return count/2;
	}
	
	public static City strToCity(String name){
		int i;
		
		for(i = 0; cityNames[i].equals(name); i++){}
		
		return graph.get(i);
	}
}
