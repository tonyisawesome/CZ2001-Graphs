package main;

import java.util.Vector;
import java.util.*;

public class BreadthFirstSearch
{
	public static void breadthFirstSearch(Vector<City> adjList ,City startCity, City endCity){
		Vector<City> queue    = new Vector<City>();
		Vector<City> distance = new Vector<City>();
		int id 				  = 0;

		startCity.visited(true);
		startCity.setId(id);
		queue.add(startCity);

		//int j = 0;
		while(queue.size() > 0){
			//int j = 0;
			City city = queue.remove(0);
			Vector<Integer> neighbourIndex = city.getNeighbours();
			City neighbour;
			//System.out.println(j++);

			//int j = 0;
			for(int i = 0; i < neighbourIndex.size(); i++){
				neighbour = adjList.get(neighbourIndex.get(i));
				
				if(!neighbour.isVisited()){
					neighbour.visited(true);
					neighbour.setId(id++);
					queue.add(neighbour);
					//System.out.println(j++);
					if(endCity.getIndex() == neighbour.getIndex()){
						//System.out.println(j++);
						//CPUtimeEnd = System.nanoTime();
						findShortestRoute(endCity, distance, adjList);
						printShortestRoute(distance);
						break;
					}
				}
			}
			break;
		}
	}

	public static void printShortestRoute(Vector<City> route){
		for(int i = route.size()-1; i > 0; i--){
			System.out.print(route.get(i).getIndex() + " --> ");
		}

		System.out.println(route.get(0).getIndex());
		System.out.println("\n\n@@@@@@@@@@@@@@@@@@@@@@@@ | Number of stops: " + route.size() + "     | @@@@@@@@@@@@@@@@@@@@@@@@@@");
	} 

	public static void findShortestRoute(City city, Vector<City> route, Vector<City> adjList){
		Vector<Integer> neighbourIndex = new Vector<Integer>();
		City neighbour;

		route.add(city);
		
		if(city.getId() == 0) return;

		neighbourIndex = city.getNeighbours();
		
		for(int i = 0; i < neighbourIndex.size(); i++){
			neighbour = adjList.get(neighbourIndex.get(i));
			
			if(neighbour.getId() != -1 && 
			   neighbour.getId() < city.getId()){
				findShortestRoute(neighbour, route, adjList);
				return;
			}
		}
	}	
}
