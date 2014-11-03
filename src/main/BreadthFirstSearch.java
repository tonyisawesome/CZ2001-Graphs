package main;

import java.util.Vector;
import java.util.*;

public class BreadthFirstSearch
{
	private static Vector<City> distance = new Vector<City>();
	
	public static Vector<City> search(Vector<City> adjList ,City startCity, City endCity){
		Vector<City> queue    = new Vector<City>();
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
						findShortestRoute(endCity);
						break;
					}
				}
			}
			
			if(found) break;
		}
		
		return distance;
	}

	public static void findShortestRoute(City city){
		Vector<City> neighbours = new Vector<City>();
		City neighbour;
		
		distance.add(city);
		
		if(city.getId() == 0) return;

		neighbours = city.getNeighbours();
		for(int i = 0; i < neighbours.size(); i++){
			neighbour = neighbours.get(i);
			
			if(neighbour.getId() != -1 && 
			   neighbour.getId() < city.getId()){
				findShortestRoute(neighbour);
				return;
			}
		}
	}	
}
