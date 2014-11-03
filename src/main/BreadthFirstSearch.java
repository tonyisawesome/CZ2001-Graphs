package main;

import java.util.Vector;
import java.util.*;

public class BreadthFirstSearch
{
	public static void breadthFirstSearch(Vector<City> adjList ,City startCity, City endCity){
		Vector<City> queue    = new Vector<City>();
		Vector<City> distance = new Vector<City>();
		int id 				  = 0;
		boolean found 		  = false;

		startCity.visited(true);
		startCity.setId(id);
		queue.add(startCity);

		while(queue.size() > 0){
			City city = queue.remove(0);
			Vector<Integer> neighbourIndex = city.getNeighbourIndex();
			City neighbour;
			
			for(int i = 0; i < neighbourIndex.size(); i++){
				neighbour = adjList.get(neighbourIndex.get(i));
				
				if(!neighbour.isVisited()){
					neighbour.visited(true);
					neighbour.setId(++id);
					queue.add(neighbour);
					city.addEdge(neighbour);
					neighbour.addEdge(city);
					
					if(endCity.getIndex() == neighbour.getIndex()){
						//CPUtimeEnd = System.nanoTime();
						found = true;
						findShortestRoute(endCity, distance);
						printShortestRoute(distance);
						break;
					}
				}
			}
			
			if(found) break;
		}
	}

	public static void printShortestRoute(Vector<City> route){
		for(int i = route.size()-1; i > 0; i--){
			System.out.print(route.get(i).getIndex() + " --> ");
		}

		System.out.println(route.get(0).getIndex());
		System.out.println("Number of stops: " + (route.size()-1));
	} 

	public static void findShortestRoute(City city, Vector<City> route){
		Vector<City> neighbours = new Vector<City>();
		City neighbour;
		System.out.println(city.getId() + "|" + city.getIndex());
		route.add(city);
		
		if(city.getId() == 0) return;

		neighbours = city.getNeighbours();
		for(int i = 0; i < neighbours.size(); i++){
			neighbour = neighbours.get(i);
			
			if(neighbour.getId() != -1 && 
			   neighbour.getId() < city.getId()){
				findShortestRoute(neighbour, route);
				return;
			}
		}
	}	
}
